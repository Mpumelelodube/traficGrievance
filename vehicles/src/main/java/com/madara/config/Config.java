package com.madara.config;

import com.madara.model.Role;
import com.madara.repository.PersonnelRepository;
import com.madara.repository.RoleRepository;
import com.madara.services.RoleService;
import com.madara.services.VehicleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository){
        return args -> {
            Role owner = new Role(
              "Owner"
            );
            Role driver = new Role(
                    "Driver"
            );
            Role conductor = new Role(
                    "Conductor"
            );

            roleRepository.saveAll(List.of(owner, driver, conductor));
        };
    }

}
