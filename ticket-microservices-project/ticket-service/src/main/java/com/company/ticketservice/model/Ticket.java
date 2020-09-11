package com.company.ticketservice.model;

import com.company.ticketservice.enums.PriorityType;
import com.company.ticketservice.enums.TicketStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Ticket extends BaseEntityModel{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    @Enumerated(value = EnumType.ORDINAL)
    private PriorityType priorityType;
    @Enumerated(value = EnumType.ORDINAL)
    private TicketStatus ticketStatus;

}
