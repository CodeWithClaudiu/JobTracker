package com.jobtracker.backend.dto;

import com.jobtracker.backend.model.WeekStatus;

import lombok.Data;

@Data
public class WeekApplicationDTO {
    private Long id;
    private int week;
    private WeekStatus status;
    private Long jobApplicationId;
}
