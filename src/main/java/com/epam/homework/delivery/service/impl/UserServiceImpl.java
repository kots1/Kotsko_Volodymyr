package com.epam.homework.delivery.service.impl;


import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.service.UserService;
import com.epam.homework.delivery.repository.UserRepository;
import com.epam.homework.delivery.сontroller.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return userRepository
                .getAllUsers()
                .stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByID(int id) {
        log.info("UserServiceImpl getUserByID id = " + id);
        return mapUserToUserDto(userRepository.getUserByID(id));
    }

    @Override
    public User getUserByLogin(String login) {
        log.info("UserServiceImpl getUserByLogin login = " + login);
        return userRepository.getUserByLogin(login);
    }

    @Override
    public UserDto createUser(User user) {
        log.info("UserServiceImpl createUser ");
        return mapUserToUserDto(userRepository.createUser(user));
    }

    @Override
    public void deleteUser(int id) {
        log.info("UserServiceImpl deleteUser id = " + id);
        userRepository.deleteUser(id);
    }

    @Override
    public UserDto updateUser(int id, User user) {
        log.info("UserServiceImpl updateUser id = " + id);
        return mapUserToUserDto(userRepository.updateUser(id, user));
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .phone(user.getPhone())
                .secondName(user.getSecondName())
                .email(user.getEmail())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .secondName(userDto.getSecondName())
                .email(userDto.getEmail())
                .build();
    }
}
