package com.example.springeurekagallery.linkedin02.services;

import com.example.springeurekagallery.linkedin02.repositories.ReadOnlyRepository;
import com.example.springeurekagallery.linkedin02.repositories.Repository;

import java.util.Collection;

public class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {
    private final Repository<TE, T> _repository;

    public BaseService(ReadOnlyRepository<TE, T> repository, Repository<TE, T> _repository) {
        super(repository);
        this._repository = _repository;
    }

    public void add(TE entity) throws Exception {
        _repository.add(entity);
    }

    public Collection<TE> getAll() {
        return _repository.getAll();
    }
}
