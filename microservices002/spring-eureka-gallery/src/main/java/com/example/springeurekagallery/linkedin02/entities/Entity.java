package com.example.springeurekagallery.linkedin02.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity<T> {
    T id;
    String name;
}
