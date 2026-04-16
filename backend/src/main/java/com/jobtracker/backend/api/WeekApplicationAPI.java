package com.jobtracker.backend.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.backend.dto.WeekApplicationDTO;
import com.jobtracker.backend.model.WeekStatus;
import com.jobtracker.backend.service.WeekApplicationService;

@RestController
@RequestMapping("/api/week-applications")
@CrossOrigin(origins = "http://localhost:4200")
public class WeekApplicationAPI {
    @Autowired
    private WeekApplicationService weekApplicationService;

    @GetMapping
    public List<WeekApplicationDTO> findAll() {
        return weekApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public WeekApplicationDTO findById(@PathVariable Long id) {
        return weekApplicationService.findById(id);
    }

    @GetMapping("/job-application/{jobApplicationId}")
    public List<WeekApplicationDTO> findByJobApplicationId(@PathVariable Long jobApplicationId) {
        return weekApplicationService.findByJobApplicationId(jobApplicationId);
    }

    @PostMapping
    public WeekApplicationDTO save(@RequestBody WeekApplicationDTO weekApplicationDTO) {
        return weekApplicationService.save(weekApplicationDTO);
    }

    @PutMapping("/{id}")
    public WeekApplicationDTO update(@PathVariable Long id, @RequestBody WeekApplicationDTO weekApplicationDTO) {
        return weekApplicationService.update(id, weekApplicationDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        weekApplicationService.delete(id);
    }

    @GetMapping("/percentages")
    public Map<WeekStatus, Double> getPercentages() {
        return weekApplicationService.getStatusPercentages();
    }
}
