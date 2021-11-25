package com.epam.homework.delivery.service.impl;


import com.epam.homework.delivery.mapper.UserMapper;
import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.service.UserService;
import com.epam.homework.delivery.repository.UserRepository;
import com.epam.homework.delivery.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        log.info("UserServiceImpl getAllUsers");
        List<User> list = new ArrayList<>(userRepository
                .findAll());
        return userRepository
                .findAll()
                .stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByID(int id) {
        log.info("UserServiceImpl getUserByID id = " + id);
        return UserMapper.INSTANCE.userToUserDto(userRepository.findById(id));
    }

    @Override
    public User getUserByLogin(String login) {
        log.info("UserServiceImpl getUserByLogin login = " + login);
        return userRepository.findByLogin(login);
    }

    @Override
    public UserDto createUser(User user) {
        log.info("UserServiceImpl createUser ");
        return UserMapper.INSTANCE.userToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(int id) {
        log.info("UserServiceImpl deleteUser id = " + id);
        userRepository.deleteById((long) id);
    }

    /*public UserDto updateUser(int id, User user) {
        log.info("UserServiceImpl updateUser id = " + id);
        return UserMapper.INSTANCE.userToUserDto(userRepository.updateUser(id, user));
    }*/


}
