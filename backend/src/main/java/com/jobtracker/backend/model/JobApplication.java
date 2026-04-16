package com.jobtracker.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class JobApplication {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String agency;


    private String linkJob;
    private String source;

    @ManyToOne
    @JoinColumn(name = "placement_profile_id")
    private PlacementProfile placementProfile; 
    

}
