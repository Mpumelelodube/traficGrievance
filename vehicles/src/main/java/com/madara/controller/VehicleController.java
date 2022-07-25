package com.madara.controller;

import com.madara.model.Vehicle;
import com.madara.services.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/save-vehicle")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.save(vehicle);
    }

    @GetMapping("/get-vehicle/{id}")
    public Optional<Vehicle> getVehicle(@PathVariable Long id){
        return vehicleService.findOne(id);
    }

    @GetMapping("/get-vehicle-by-licencePlate/{licencePlate}")
    public Optional<Vehicle> getVehicleByLicencePlate(@PathVariable String licencePlate){
        return vehicleService.findByLicencePlate(licencePlate);
    }

    @GetMapping("/get-all-vehicles")
    public List<Vehicle> getVehicle(){
        return vehicleService.findAll();
    }
}
