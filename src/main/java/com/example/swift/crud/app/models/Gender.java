package com.example.swift.crud.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

    MALE("Male"), FEMALE("Female"), OTHER("Other");

    private final String genderName;

    Gender(String genderName) {
        this.genderName = genderName;
    }

}
