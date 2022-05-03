package miu.edu.cs544.sirjana.jobsearch.controller;


import miu.edu.cs544.sirjana.jobsearch.entity.ScreeningInterview;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.ScreeningInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScreeningController {

    @Autowired
    private ScreeningInterviewService screeningInterviewService;

    @GetMapping("/screeningInterviews")
    public List<ScreeningInterview> getAll(){

        return screeningInterviewService.getAllScreeningInterview();

    }

    @GetMapping("/screeningInterview/{screeningInterview_id}")
    public ScreeningInterview getOne(@PathVariable int screeningInterview_id){
        ScreeningInterview screeningInterview = screeningInterviewService.getOneScreeningInterview(screeningInterview_id);
        if (screeningInterview == null) {
            throw new Allexception(screeningInterview_id);
        }
        return screeningInterview;

    }

    @DeleteMapping("/screeningInterview/{screeningInterview_id}")
    public void deleteOne(@PathVariable int screeningInterview_id){
        ScreeningInterview screeningInterview = screeningInterviewService.getOneScreeningInterview(screeningInterview_id);
        if (screeningInterview != null) {
            screeningInterviewService.deleteOneScreeningInterview(screeningInterview_id);
        } else {
            throw new Allexception(screeningInterview_id);
        }

    }

    @PostMapping("/screeningInterviews")
    public ScreeningInterview addOne(@RequestBody ScreeningInterview screeningInterview){
        screeningInterviewService.addOneScreeningInterview(screeningInterview);

        return screeningInterview;
    }

    @PutMapping("/screeningInterview/{screeningInterview_id}")
    public ScreeningInterview updateOne(@PathVariable int screeningInterview_id,@RequestBody ScreeningInterview screeningInterview){
        screeningInterviewService.updateOneScreeningInterview(screeningInterview_id, screeningInterview);

        ScreeningInterview screeningInterview1 = screeningInterviewService.getOneScreeningInterview(screeningInterview_id);
        return screeningInterview1;
    }
}

