package miu.edu.cs544.sirjana.jobsearch.controller;


import miu.edu.cs544.sirjana.jobsearch.entity.Application;
import miu.edu.cs544.sirjana.jobsearch.entity.HiringManagerInterview;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.HiringManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HiringController {

    @Autowired
    private HiringManagerService hiringManagerService;

    @GetMapping("/hiringManagerInterviews")
    public List<HiringManagerInterview> getAll(){

        return hiringManagerService.getAllHiringManagerInterviews();

    }


    @GetMapping("/hiringManagerInterview/{hiringManagerInterview_id}")
    public HiringManagerInterview getOne(@PathVariable int hiringManagerInterview_id){
        HiringManagerInterview hiringManagerInterview = hiringManagerService.getOneHiringManagerInterview(hiringManagerInterview_id);
        if (hiringManagerInterview == null) {
            throw new Allexception(hiringManagerInterview_id);
        }
        return hiringManagerInterview;

    }

    @DeleteMapping("/hiringManagerInterview/{hiringManagerInterview_id}")
    public void deleteOne(@PathVariable int hiringManagerInterview_id){
        HiringManagerInterview hiringManagerInterview = hiringManagerService.getOneHiringManagerInterview(hiringManagerInterview_id);
        if (hiringManagerInterview != null) {
            hiringManagerService.deleteOneHiringManagerInterview(hiringManagerInterview_id);
        } else {
            throw new Allexception(hiringManagerInterview_id);
        }

    }

    @PostMapping("/hiringManagerInterviews")
    public HiringManagerInterview addOne(@RequestBody HiringManagerInterview hiringmanagerinterview){
        hiringManagerService.addOneHiringManagerInterview(hiringmanagerinterview);

        return hiringmanagerinterview;
    }


    @PutMapping("/hiringManagerInterview/{hiringManagerInterview_id}")
    public HiringManagerInterview updateOne(@PathVariable int hiringManagerInterview_id,@RequestBody HiringManagerInterview hiringManagerInterview){
        hiringManagerService.updateOneHiringManagerInterview(hiringManagerInterview_id, hiringManagerInterview);

        HiringManagerInterview hiringManagerInterview1 = hiringManagerService.getOneHiringManagerInterview(hiringManagerInterview_id);
        return hiringManagerInterview1;
    }
}

