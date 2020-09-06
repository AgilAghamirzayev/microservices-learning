package com.example.springeurekagallery.linkedin02.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseEntity <T> extends Entity<T>{

    private boolean isModified;

    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
        isModified = false;
    }


}
