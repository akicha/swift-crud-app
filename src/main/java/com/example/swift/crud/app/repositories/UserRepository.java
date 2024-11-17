package com.example.swift.crud.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.swift.crud.app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
