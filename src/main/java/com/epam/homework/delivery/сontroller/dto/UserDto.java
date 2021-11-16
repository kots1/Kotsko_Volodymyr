package com.epam.homework.delivery.сontroller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String login;
    private String name;
    private String secondName;
    private String email;
    private String phone;
}
