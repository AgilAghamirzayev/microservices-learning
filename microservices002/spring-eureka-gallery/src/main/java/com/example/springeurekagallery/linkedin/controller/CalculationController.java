package com.example.springeurekagallery.linkedin.controller;

import com.example.springeurekagallery.linkedin.entity.Calculation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculations")
public class CalculationController {

    public static final String PATTERN = "^-?+\\d+\\.?+\\d*$";


    @GetMapping("power")
    public Calculation pow(@RequestParam(value = "base") String b, @RequestParam(value = "exponent") String e) {
        List<String> input = new ArrayList<>();
        input.add(b);
        input.add(e);
        List<String> output = new ArrayList<>();
        String powValue;
        if (b != null && e != null && b.matches(PATTERN) && e.matches(PATTERN))
            powValue = String.valueOf(Math.pow(Double.parseDouble(b), Double.parseDouble(e)));
        else
            powValue = "Base or/and Exponent is/are not set to numeric value";
        output.add(powValue);
        return new Calculation(input, output, "power");
    }

    @GetMapping("sqrt/{value:.+}")
    public Calculation sqrt(@PathVariable("value") String aValue) {
        List<String> input = new ArrayList<>();
        input.add(aValue);
        List<String> output = new ArrayList<>();
        String sqrtValue;
        if (aValue != null && aValue.matches(PATTERN))
            sqrtValue = String.valueOf(Math.sqrt(Double.parseDouble(aValue)));
        else
            sqrtValue = "Input value is not set to numeric va'.";
        output.add(sqrtValue);
        return new Calculation(input, output, "sqrt");
    }
}
