package com.example.swift.crud.app.controllers;

import com.example.swift.crud.app.models.User;
import com.example.swift.crud.app.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User create(@RequestBody final User user) {
        log.info(String.format("Creating user... %s", user.getFirst_name()));
        return userService.saveUser(user);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteUser(@PathVariable @NonNull Long id) {
        userService.deleteUserById(id);
    }

}
