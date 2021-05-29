package com.in28minutes.limits_service.controller;

import com.in28minutes.limits_service.bean.Limits;
import com.in28minutes.limits_service.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public record LimitsController(Configuration configuration) {

    @GetMapping
    public Limits retrieveLimits() {

        return new Limits(configuration.getMin(), configuration.getMax());
    }
}
