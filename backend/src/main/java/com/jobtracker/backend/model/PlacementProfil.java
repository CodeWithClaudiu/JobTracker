package com.jobtracker.backend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class PlacementProfil {
    private int id;
    private String name;
    private String cityPlacement;

    //@OneToMany(mappedBy = "portalUser", cascade = CascadeType.ALL)
    //private List<JobApplication> jobApplications;

   
}
