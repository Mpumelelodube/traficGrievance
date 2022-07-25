package com.madara.services;

import com.madara.model.Vehicle;
import com.madara.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService extends IService<Vehicle, VehicleRepository>{
    public VehicleService(VehicleRepository repository) {
        super(repository);
    }

    public Optional<Vehicle> findByLicencePlate(String licencePlate) {
        return repository.findByLicencePlate(licencePlate);
    }
}
