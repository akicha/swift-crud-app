
package com.example.swift.crud.app.controllers;

import com.example.swift.crud.app.models.Gender;
import com.example.swift.crud.app.services.GenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
public class GenderController {

    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public List<Gender> getGenders() {
        return genderService.getGenders();
    }

}

