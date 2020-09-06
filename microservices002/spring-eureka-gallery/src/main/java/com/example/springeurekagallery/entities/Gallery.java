package com.example.springeurekagallery.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Gallery {

    private Integer id;
    List<Object> images;
}
