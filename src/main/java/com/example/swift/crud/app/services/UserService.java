package com.example.swift.crud.app.services;

import com.example.swift.crud.app.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User saveUser(User user);
    void deleteUserById(Long id);
}