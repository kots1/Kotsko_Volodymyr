package com.epam.homework.delivery.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserDto {
    @NotBlank
    private String login;
    @NotBlank
    private String name;
    @NotBlank
    private String secondName;
    @Email
    private String email;
    @NotBlank
    private String phone;
}
