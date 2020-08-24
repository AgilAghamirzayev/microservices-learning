package com.example.forexservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExchangeValueNotFound extends RuntimeException {
    public ExchangeValueNotFound(String message) {
        super(message);
    }
}
