package com.example.swift.crud.app.services.impl;

import com.example.swift.crud.app.models.Gender;
import com.example.swift.crud.app.services.GenderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    public List<Gender> getGenders() {
        return List.of(Gender.values());
    }

}
