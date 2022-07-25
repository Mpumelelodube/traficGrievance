package com.madara.service;

import com.madara.model.Grievance;
import com.madara.repository.GrievanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Service
public class GrievanceService extends IService<Grievance, GrievanceRepository>{

    private final RestTemplate restTemplate;
    public GrievanceService(GrievanceRepository repository, RestTemplate restTemplate) {
        super(repository);
        this.restTemplate = restTemplate;
    }

    public List<Grievance> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    /*public void registerClient(Object){
        restTemplate.postForEntity("http://localhost:8090/api/v1/griever/save",Object,)
    }*/
}
