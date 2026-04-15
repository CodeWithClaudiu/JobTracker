package com.jobtracker.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobtracker.backend.model.JobApplication;

import com.jobtracker.backend.service.JobApplicationService;

@RestController //questa annotazione indica che questa classe è un controller REST, che gestisce le richieste HTTP e restituisce risposte in formato JSON o XML. e un controller invece è
@RequestMapping("/api/job-applications") //questa annotazione specifica il percorso base per tutte le richieste gestite da questo controller. In questo caso, tutte le richieste che iniziano con "/api/job-applications" saranno indirizzate a questo controller.
public class JobApplicationAPI {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping //questa annotazione indica che questo metodo gestisce le richieste HTTP GET. Quando viene ricevuta una richiesta GET al percorso "/api/job-applications", questo metodo verrà eseguito.
    public Object getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @PostMapping
    public Object createJobApplication(JobApplication jobApplication) {
        return jobApplicationService.createJobApplication(jobApplication);
    }

    @GetMapping("/{id}")
    public Object getJobApplicationById(Long id) {
        return jobApplicationService.getJobApplicationById(id);
    }

    @PostMapping("/{id}")
    public Object updateJobApplication(Long id, Object updatedApplication) {
        return jobApplicationService.updateJobApplication(id, (com.jobtracker.backend.model.JobApplication) updatedApplication);
    }
    
}
