package com.example.springeurekagallery.linkedin02.services;

import com.example.springeurekagallery.linkedin02.repositories.ReadOnlyRepository;

public class ReadOnlyBaseService<TE, T> {
    private final ReadOnlyRepository<TE, T> repository;

    public ReadOnlyBaseService(ReadOnlyRepository<TE, T> repository) {
        this.repository = repository;
    }
}
