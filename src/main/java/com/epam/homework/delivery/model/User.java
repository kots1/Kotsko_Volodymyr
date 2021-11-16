package com.epam.homework.delivery.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String login;
    private String name;
    private String secondName;
    private String password;
    private String email;
    private String phone;
}
