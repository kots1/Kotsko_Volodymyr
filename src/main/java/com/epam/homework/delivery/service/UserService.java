package com.epam.homework.delivery.service;

import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.сontroller.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserByID(int id);
    User getUserByLogin(String login);

    UserDto createUser(User user);


    void deleteUser(int id);

    UserDto updateUser(int id,User user);
}
