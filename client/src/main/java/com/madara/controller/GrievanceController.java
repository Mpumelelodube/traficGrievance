package com.madara.controller;

import com.madara.model.Grievance;
import com.madara.service.GrievanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/grievance")
public record GrievanceController(GrievanceService grievanceService) {

    @Autowired
    public GrievanceController {
    }

    @PostMapping("/register")
    public Grievance register(@RequestBody Grievance grievance){
        System.out.println(grievance);
        return grievanceService.save(grievance);
    }

    @GetMapping("/get-grievances/{email}")
    public List<Grievance> getAllGrievances(@PathVariable String email) {
        return grievanceService.findByEmail(email);
    }

    @GetMapping("/get-grievance/{id}")
    public Optional<Grievance> getGriever(@PathVariable Long id) {
        return grievanceService.findOne(id);
    }
}
