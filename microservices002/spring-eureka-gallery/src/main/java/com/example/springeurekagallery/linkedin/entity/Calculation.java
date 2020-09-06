package com.example.springeurekagallery.linkedin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Calculation {

    private List<String> input;
    private List<String> output;
    private String power;


}
