package com.company.ticketservice.enums;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Teclili"),
    LOW("Onemsiz"),
    HIGH("Onemli");

    private final String label;

    PriorityType(String label) {
        this.label = label;
    }
}
