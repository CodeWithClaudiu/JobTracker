package com.jobtracker.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jobtracker.backend.dto.WeekApplicationDTO;
import com.jobtracker.backend.model.WeekApplication;

@Mapper(componentModel = "spring")
public interface WeekApplicationMapper {
    
    @Mapping(source = "jobApplication.id", target = "jobApplicationId")
    WeekApplicationDTO toDTO(WeekApplication weekApplication);

    List<WeekApplicationDTO> toDTOs(List<WeekApplication> weekApplications);

    @Mapping(source = "jobApplicationId", target = "jobApplication.id")
    WeekApplication toEntity(WeekApplicationDTO weekApplicationDTO);

    List<WeekApplication> toEntities(List<WeekApplicationDTO> weekApplicationDTOs);
}
