package com.madara.controller;

import com.madara.model.Griever;
import com.madara.service.GrieverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/griever")
public record GrieverController(GrieverService grieverService) {
    @Autowired
    public GrieverController {
    }

    @PostMapping("/register-griever")
    public Griever register(@RequestBody Griever griever){
        if (grieverService.findByEmail(griever.getEmail()).isEmpty()){
            return grieverService.save(griever);
        }else {
            throw  new IllegalStateException("email already taken");
        }
    }

    @GetMapping("/get-grievers")
    public List<Griever> getAllGrievers() {
        return grieverService.findAll();
    }

    @GetMapping("/get-griever/{id}")
    public Optional<Griever> getGriever(@PathVariable Long id) {
        return grieverService.findOne(id);
    }

}
