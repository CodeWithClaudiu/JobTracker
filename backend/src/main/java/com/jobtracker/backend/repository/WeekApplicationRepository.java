package com.jobtracker.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtracker.backend.model.WeekApplication;

public interface WeekApplicationRepository  extends JpaRepository<WeekApplication, Long> {

    List<WeekApplication> findByJobApplicationId(Long jobApplicationId);
}
