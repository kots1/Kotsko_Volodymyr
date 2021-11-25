package com.epam.homework.delivery.model;

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
@Table(name = "User")
public class User {
    //public User(){}
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Id
    private Long id;
    @NotBlank
    private String login;
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
