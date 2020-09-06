package com.example.springeurekagallery.linkedin02.repositories;

import java.util.Collection;
public interface ReadOnlyRepository<TE, T> {

    boolean contains();
    TE get();
    Collection<TE> getAll();
}
