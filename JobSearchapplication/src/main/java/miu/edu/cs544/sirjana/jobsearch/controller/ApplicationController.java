package miu.edu.cs544.sirjana.jobsearch.controller;


import miu.edu.cs544.sirjana.jobsearch.entity.*;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/applications")
    public List<Application> getAll(){

        return applicationService.getAllApplication();

    }


    @GetMapping("/application/{application_id}")
    public Application getOne(@PathVariable int application_id){
        Application application = applicationService.getOneApplication(application_id);
        if (application == null) {
            throw new Allexception(application_id);
        }
        return application;

    }

    @DeleteMapping("/application/{application_id}")
    public void deleteOne(@PathVariable int application_id){
        Application application = applicationService.getOneApplication(application_id);
        if (application != null) {
            applicationService.deleteOneApplication(application_id);
        } else {
            throw new Allexception(application_id);
        }

    }

    @PostMapping("/applications")
    public Application addOne(@RequestBody Application application){
        applicationService.addOneApplication(application);

        return application;
    }

    @PutMapping("/application/{application_id}")
    public Application updateOne(@PathVariable int application_id,@RequestBody Application application){
        applicationService.updateOneApplication(application_id, application);

        Application application1 = applicationService.getOneApplication(application_id);
        return application1;
    }

    @PutMapping("/application/{application_id}/hiringinterview")
    public Application updateHiringInterviewFromApplication(@PathVariable int application_id,@RequestBody HiringManagerInterview hiringManagerInterview){
        Application application1= applicationService.updateHiringInterviewFromApplication(application_id, hiringManagerInterview);

        return application1;
    }

    @PutMapping("/application/{application_id}/screeninginterview")
    public Application updateScreeningInterviewFromApplication(@PathVariable int application_id,@RequestBody ScreeningInterview screeningInterview){
        Application application1= applicationService.updateScreeningInterviewFromApplication(application_id, screeningInterview);

        return application1;
    }

    @PutMapping("/application/{application_id}/technicalinterview")
    public Application updateTechnicalInterviewFromApplication(@PathVariable int application_id,@RequestBody TechnicalInterview technicalInterview){
        Application application1= applicationService.updateTechnicalInterviewFromApplication(application_id, technicalInterview);

        return application1;
    }

}
