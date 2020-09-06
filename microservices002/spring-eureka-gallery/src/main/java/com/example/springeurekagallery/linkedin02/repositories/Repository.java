package com.example.springeurekagallery.linkedin02.repositories;

public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {
    void add(TE entity);
    void update(TE entity);
    void remove(T id);
}
