package com.example.springeurekagallery.controllers;

import com.example.springeurekagallery.entities.Gallery;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final RestTemplate restTemplate;
    private final Environment environment;

    @GetMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.

        return "Hello from Gallery Service running at port: " + environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Gallery getGallery(@PathVariable("id") Integer id) {
        Gallery gallery = new Gallery();
        gallery.setId(id);

        List<Object> images = restTemplate.getForObject("http://image-service/images", List.class);
        gallery.setImages(images);

        return gallery;
    }

    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + environment.getProperty("local.server.port");
    }
}
