package com.jobtracker.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.jobtracker.backend.dto.JobApplicationDTO;
import com.jobtracker.backend.model.JobApplication;


@Mapper(componentModel = "spring") //questa annotazione indica a MapStruct di generare un'implementazione del mapper come un bean Spring, consentendo l'iniezione automatica del mapper nei componenti Spring.
//definisce un'interfaccia per il mapping tra l'entità JobApplication e il DTO JobApplicationDTO. MapStruct genererà automaticamente l'implementazione di questa interfaccia durante la compilazione, basandosi sulle convenzioni di naming dei metodi.
public interface JobApplicationMapper {

    JobApplicationDTO toDTO(JobApplication jobApplication);
    List<JobApplicationDTO> toDTOList(List<JobApplication> jobApplications);


    JobApplication toEntity(JobApplicationDTO jobApplicationDTO);
    List<JobApplication> toEntityList(List<JobApplicationDTO> jobApplicationDTOs);

}
