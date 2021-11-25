package com.epam.homework.delivery.service;

import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserByID(int id);
    User getUserByLogin(String login);

    UserDto createUser(User user);


    void deleteUser(int id);

}
