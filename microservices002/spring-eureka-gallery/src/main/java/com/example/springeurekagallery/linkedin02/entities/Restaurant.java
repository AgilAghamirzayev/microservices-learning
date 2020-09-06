package com.example.springeurekagallery.linkedin02.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Restaurant extends BaseEntity<String> {

    private List<Table> tables = new ArrayList<>();

    public Restaurant(String id, String name, List<Table> tables) {
        super(id, name);
        this.tables = tables;
    }

}
