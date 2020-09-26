package com.company.ticketservice.enums;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("aciq"),
    IN_PROGRESS("davam edir"),
    RESOLVED("hell edildi"),
    CLOSED("baglandi");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
