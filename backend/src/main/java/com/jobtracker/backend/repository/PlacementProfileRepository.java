package com.jobtracker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtracker.backend.model.PlacementProfile;

public interface PlacementProfileRepository extends JpaRepository<PlacementProfile, Long>{
    
}
