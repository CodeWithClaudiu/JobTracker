package com.jobtracker.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.jobtracker.backend.dto.JobApplicationDTO;
import com.jobtracker.backend.mapper.JobApplicationMapper;
import com.jobtracker.backend.model.JobApplication;
import com.jobtracker.backend.repository.JobApplicationRepository;

@Service // annotazione per indicare che questa classe è un servizio Spring
@Validated // permette di utilizzare le annotazioni di validazione sui metodi del servizio
public class JobApplicationService {

    @Autowired // inietta automaticamente un'istanza di JobApplicationRepository
    private JobApplicationRepository jobApplicationRepo;

        @Autowired
    private JobApplicationMapper jobApplicationMapper;

    public JobApplication createJobApplication(JobApplication jobApplication) {
        return jobApplicationRepo.save(jobApplication);
    }

    public JobApplicationDTO getJobApplicationById(Long id) {
        return jobApplicationRepo.findById(id)
                .map(jobApplicationMapper::toDTO)
                .orElse(null);
    }

    public JobApplication updateJobApplication(Long id, JobApplication updatedApplication) {
        return jobApplicationRepo.findById(id)
                .map(application -> {
                    application.setAgency(updatedApplication.getAgency());
                    application.setLinkJob(updatedApplication.getLinkJob());
                    application.setSource(updatedApplication.getSource());
                    return jobApplicationRepo.save(application);
                })
                .orElse(null);
    }

    public void deleteJobApplication(Long id) {
        jobApplicationRepo.deleteById(id);
    }

    public List<JobApplicationDTO> getAllJobApplications() {
        return jobApplicationRepo.findAll().stream()
                .map(jobApplicationMapper::toDTO)
                .collect(Collectors.toList());
    }






    
}
