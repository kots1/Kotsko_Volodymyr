package com.epam.homework.delivery.model;

import java.util.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//@Data
//@Builder
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Id
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    @Column(name = "first_name")
    private String name;
    @NotBlank
    @Column(name = "second_name")
    private String secondName;
    @Email
    private String email;
    @NotBlank
    private String phone;


}
