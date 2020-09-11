package com.company.accountservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Account {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private Date createdAt;
    private Boolean isActive;

}
