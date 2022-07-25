package com.madara.controller;

import com.madara.model.Personnel;
import com.madara.services.PersonnelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personnel")
public class PersonnelController {
    private final PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/save-personnel")
    private Personnel savePersonnel(@RequestBody Personnel personnel){
        return personnelService.save(personnel);
    }
}
