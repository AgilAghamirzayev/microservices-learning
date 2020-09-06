package com.example.springeurekagallery.linkedin02.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
public class Table extends BaseEntity<BigInteger> {

    private int capacity;

    public Table(BigInteger id, String name, int capacity) {
        super(id, name);
        this.capacity = capacity;
    }

}
