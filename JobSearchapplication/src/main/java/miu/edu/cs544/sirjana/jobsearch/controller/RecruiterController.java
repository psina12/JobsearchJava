package miu.edu.cs544.sirjana.jobsearch.controller;

import miu.edu.cs544.sirjana.jobsearch.entity.Application;
import miu.edu.cs544.sirjana.jobsearch.entity.Client;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.entity.Recruiter;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping("/recruiters")
    public List<Recruiter> getAll(){

        return recruiterService.getAllRecruiter();

    }


    @GetMapping("/recruiter/{recruiter_id}")
    public Recruiter getOne(@PathVariable int recruiter_id){
        Recruiter recruiter = recruiterService.getOneRecruiter(recruiter_id);
        if (recruiter == null) {
            throw new Allexception(recruiter_id);
        }
        return recruiter;

    }

    @DeleteMapping("/recruiter/{recruiter_id}")
    public void deleteOne(@PathVariable int recruiter_id){
        Recruiter recruiter = recruiterService.getOneRecruiter(recruiter_id);
        if (recruiter != null) {
            recruiterService.deleteOneRecruiter(recruiter_id);
        } else {
            throw new Allexception(recruiter_id);
        }

    }

    @PostMapping("/recruiters")
    public Recruiter addOne(@RequestBody Recruiter recruiter){
        recruiterService.addOneRecruiter(recruiter);

        return recruiter;
    }

    @PutMapping("/recruiter/{recruiter_id}")
    public Recruiter updateOne(@PathVariable int recruiter_id,@RequestBody Recruiter recruiter){
        recruiterService.updateOneRecruiter(recruiter_id, recruiter);

        Recruiter recruiter1 = recruiterService.getOneRecruiter(recruiter_id);
        return recruiter1;
    }


    @PutMapping("/recruiter/{recruiter_id}/clients")
    public Recruiter updateClientFromRecruiter(@PathVariable int recruiter_id,@RequestBody List<Client> clients){
        Recruiter recruiter2 = recruiterService.updateClientFromRecruiter(recruiter_id, clients);
        return recruiter2;
    }

    @PutMapping("/recruiter/{recruiter_id}/jobs")
    public Recruiter updateJobsFromRecruiter(@PathVariable int recruiter_id, @RequestBody List<Job> jobs){
         recruiterService.updateJobsFromRecruiter(recruiter_id,jobs);
        Recruiter recruiter3 = recruiterService.updateJobsFromRecruiter(recruiter_id, jobs);
        return recruiter3;

    }

}

