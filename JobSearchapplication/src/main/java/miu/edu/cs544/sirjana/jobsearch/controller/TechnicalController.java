package miu.edu.cs544.sirjana.jobsearch.controller;


import miu.edu.cs544.sirjana.jobsearch.entity.TechnicalInterview;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.TechnicalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechnicalController {

    @Autowired
    private TechnicalInterviewService technicalInterviewService;

    @GetMapping("/technicalInterviews")
    public List<TechnicalInterview> getAll(){

        return technicalInterviewService.getAllTechnicalInterviews();

    }


    @GetMapping("/technicalInterview/{technicalInterview_id}")
    public TechnicalInterview getOne(@PathVariable int technicalInterview_id){
        TechnicalInterview technicalInterview = technicalInterviewService.getOneTechnicalInterview(technicalInterview_id);
        if (technicalInterview == null) {
            throw new Allexception(technicalInterview_id);
        }
        return technicalInterview;

    }

    @DeleteMapping("/technicalInterview/{technicalInterview_id}")
    public void deleteOne(@PathVariable int technicalInterview_id){
        TechnicalInterview technicalInterview = technicalInterviewService.getOneTechnicalInterview(technicalInterview_id);
        if (technicalInterview != null) {
            technicalInterviewService.deleteOneTechnicalInterview(technicalInterview_id);
        } else {
            throw new Allexception(technicalInterview_id);
        }

    }

    @PostMapping("/technicalInterviews")
    public TechnicalInterview addOne(@RequestBody TechnicalInterview technicalInterview){
        technicalInterviewService.addOneTechnicalInterview(technicalInterview);

        return technicalInterview;
    }

    @PutMapping("/technicalInterview/{technicalInterview_id}")
    public TechnicalInterview updateOne(@PathVariable int technicalInterview_id,@RequestBody TechnicalInterview technicalInterview){
        technicalInterviewService.updateOneTechnicalInterview(technicalInterview_id, technicalInterview);

        TechnicalInterview technicalInterview1 = technicalInterviewService.getOneTechnicalInterview(technicalInterview_id);
        return technicalInterview1;
    }
}

