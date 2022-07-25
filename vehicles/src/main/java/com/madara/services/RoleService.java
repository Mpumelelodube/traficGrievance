package com.madara.services;

import com.madara.model.Role;
import com.madara.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends IService<Role, RoleRepository>{
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}
