package com.madara.service;

import com.madara.model.Griever;
import com.madara.repository.GrieverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrieverService extends IService<Griever, GrieverRepository>{
    public GrieverService(GrieverRepository repository) {
        super(repository);
    }

    public List<Griever> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
