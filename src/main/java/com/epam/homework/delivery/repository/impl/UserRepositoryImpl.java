package com.epam.homework.delivery.repository.impl;

import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private static int ID = 1;
    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public User getUserByID(int id) {
        return users.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public User getUserByLogin(String name) {
        return users.stream()
                .filter(e -> e.getLogin().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public User createUser(User user) {
        user.setId(ID++);
        users.add(user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        users.remove(getUserByID(id));
    }

    @Override
    public User updateUser(int id, User user) {
        boolean isDeleted = users.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            users.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }
}
