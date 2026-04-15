package com.jobtracker.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobtracker.backend.model.PlacementProfile;
import com.jobtracker.backend.dto.PlacementProfileDTO;
import com.jobtracker.backend.repository.PlacementProfileRepository;

import com.jobtracker.backend.mapper.PlacementProfileMapper;
import com.jobtracker.backend.repository.PlacementProfileRepository;

@Service
public class PlacementProfileService {

    @Autowired
    private PlacementProfileRepository PlacementProfileRepo;

    @Autowired
    private PlacementProfileMapper PlacementProfileMapper;

    public PlacementProfile createPlacementProfile(PlacementProfile placementProfile) {
        return PlacementProfileRepo.save(placementProfile);
    }

    public PlacementProfileDTO getPlacementProfileById(Long id) {
        return PlacementProfileRepo.findById(id)
                .map(PlacementProfileMapper::toDTO)
                .orElse(null);
    }

    public PlacementProfile updatePlacementProfile(Long id, PlacementProfile updatedProfile) {
        return PlacementProfileRepo.findById(id)
                .map(profile -> {
                    profile.setName(updatedProfile.getName());
                    profile.setCityPlacement(updatedProfile.getCityPlacement());
                    return PlacementProfileRepo.save(profile);
                })
                .orElse(null);
    }

    public void deletePlacementProfile(Long id) {
        PlacementProfileRepo.deleteById(id);
    }

    public List<PlacementProfileDTO> getAllPlacementProfiles() {
        return PlacementProfileRepo.findAll().stream()
                .map(PlacementProfileMapper::toDTO)
                .collect(Collectors.toList());
    }

  

   












    
}
