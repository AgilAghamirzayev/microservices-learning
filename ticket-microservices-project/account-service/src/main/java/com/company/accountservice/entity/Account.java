package com.company.accountservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collation = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Account {

    private String id = UUID.randomUUID().toString();
    private String username;
    private String email;
    private String passwd;
    private Date createdAt;
    private Boolean isActive;

}
