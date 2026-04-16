package com.jobtracker.backend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class PlacementProfile {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String name;

    
    private String cityPlacement;

    @OneToMany(mappedBy = "placementProfile", cascade = CascadeType.ALL)
    private List<JobApplication> jobApplications;

   
}
