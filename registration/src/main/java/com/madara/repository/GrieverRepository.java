package com.madara.repository;

import com.madara.model.Griever;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GrieverRepository extends JpaRepository<Griever, Long> {
    List<Griever> findByEmail(String email);
}
