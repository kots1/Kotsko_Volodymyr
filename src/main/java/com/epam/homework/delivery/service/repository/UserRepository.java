package com.epam.homework.delivery.service.repository;

import com.epam.homework.delivery.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserByID(int id);

    User getUserByLogin(String name);

    User createUser(User user);

    void deleteUser(int id);

    User updateUser(int id, User user);
}
