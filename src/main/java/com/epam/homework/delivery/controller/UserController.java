package com.epam.homework.delivery.controller;

import com.epam.homework.delivery.model.User;
import com.epam.homework.delivery.service.UserService;
import com.epam.homework.delivery.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/user")
    public UserDto createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUserByID(id);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/user/{id}")
//    public UserDto updateUser(@PathVariable int id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
