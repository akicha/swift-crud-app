package com.example.swift.crud.app.services.impl;

import com.example.swift.crud.app.models.User;
import com.example.swift.crud.app.repositories.UserRepository;
import com.example.swift.crud.app.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
