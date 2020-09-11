package com.company.accountservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document("account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Account {

    private String id = UUID.randomUUID().toString();
    private String username;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private String password;
    private Date createdAt;
    private Boolean active;

}
