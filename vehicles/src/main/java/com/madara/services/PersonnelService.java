package com.madara.services;

import com.madara.model.Personnel;
import com.madara.repository.PersonnelRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonnelService extends IService<Personnel, PersonnelRepository>{
    public PersonnelService(PersonnelRepository repository) {
        super(repository);
    }
}
