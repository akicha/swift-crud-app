package com.example.swift.crud.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private Integer age;
    /*   It will be better to use gender attribute as an enum object, just in case we want to add more attributes in Gender object
        private Gender gender;*/
    private String gender;
    private String comments;

}
