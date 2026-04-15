package com.jobtracker.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class WeekApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int week;
    
    @Enumerated(EnumType.STRING)
    private WeekStatus status;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private JobApplication jobApplication;
}
