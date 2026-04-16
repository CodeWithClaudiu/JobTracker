package com.jobtracker.backend.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobtracker.backend.dto.WeekApplicationDTO;
import com.jobtracker.backend.mapper.WeekApplicationMapper;
import com.jobtracker.backend.model.JobApplication;
import com.jobtracker.backend.model.WeekApplication;
import com.jobtracker.backend.model.WeekStatus;
import com.jobtracker.backend.repository.JobApplicationRepository;
import com.jobtracker.backend.repository.WeekApplicationRepository;

@Service
public class WeekApplicationService {
    @Autowired
    private WeekApplicationRepository weekApplicationRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private WeekApplicationMapper weekApplicationMapper;

    public List<WeekApplicationDTO> findAll() {
        List<WeekApplication> weekApplications = weekApplicationRepository.findAll();
        return weekApplicationMapper.toDTOs(weekApplications);
    }

    public WeekApplicationDTO findById(Long id) {
        WeekApplication weekApplication = weekApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WeekApplication non trovata"));

        return weekApplicationMapper.toDTO(weekApplication);
    }

    public List<WeekApplicationDTO> findByJobApplicationId(Long jobApplicationId) {
        List<WeekApplication> weekApplications =
                weekApplicationRepository.findByJobApplicationId(jobApplicationId);

        return weekApplicationMapper.toDTOs(weekApplications);
    }

    public WeekApplicationDTO save(WeekApplicationDTO weekApplicationDTO) {
        JobApplication jobApplication = jobApplicationRepository
                .findById(weekApplicationDTO.getJobApplicationId())
                .orElseThrow(() -> new RuntimeException("JobApplication non trovata"));

        WeekApplication weekApplication = weekApplicationMapper.toEntity(weekApplicationDTO);
        weekApplication.setJobApplication(jobApplication);

        WeekApplication savedWeekApplication = weekApplicationRepository.save(weekApplication);
        return weekApplicationMapper.toDTO(savedWeekApplication);
    }

    public WeekApplicationDTO update(Long id, WeekApplicationDTO weekApplicationDTO) {
        WeekApplication existingWeekApplication = weekApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WeekApplication non trovata"));

        JobApplication jobApplication = jobApplicationRepository
                .findById(weekApplicationDTO.getJobApplicationId())
                .orElseThrow(() -> new RuntimeException("JobApplication non trovata"));

        existingWeekApplication.setWeek(weekApplicationDTO.getWeek());
        existingWeekApplication.setStatus(weekApplicationDTO.getStatus());
        existingWeekApplication.setJobApplication(jobApplication);

        WeekApplication updatedWeekApplication =
                weekApplicationRepository.save(existingWeekApplication);

        return weekApplicationMapper.toDTO(updatedWeekApplication);
    }

    public void delete(Long id) {
        WeekApplication weekApplication = weekApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WeekApplication non trovata"));

        weekApplicationRepository.delete(weekApplication);
    }

        public Map<WeekStatus, Double> getStatusPercentages() {
        List<WeekApplication> weekApplications = weekApplicationRepository.findAll();

        Map<WeekStatus, Integer> counts = new EnumMap<>(WeekStatus.class);
        Map<WeekStatus, Double> percentages = new EnumMap<>(WeekStatus.class);

        for (WeekStatus status : WeekStatus.values()) {
            counts.put(status, 0);
            percentages.put(status, 0.0);
        }

        if (weekApplications.isEmpty()) {
            return percentages;
        }

        for (WeekApplication weekApplication : weekApplications) {
            WeekStatus status = weekApplication.getStatus();
            counts.put(status, counts.get(status) + 1);
        }

        int total = weekApplications.size();

        for (WeekStatus status : WeekStatus.values()) {
            double percentage = (counts.get(status) * 100.0) / total;
            percentages.put(status, percentage);
        }

        return percentages;
    }
}
