package miu.edu.cs544.sirjana.jobsearch.controller;

import miu.edu.cs544.sirjana.jobsearch.entity.Application;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.entity.Skill;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.JobRepository;
import miu.edu.cs544.sirjana.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAll(){

            return jobService.getAllJobs();

    }


    @GetMapping("/job/{job_id}")
    public Job getOne(@PathVariable int job_id){
            Job job = jobService.getOneJob(job_id);
            if (job == null) {
                throw new Allexception(job_id);
            }
            return job;

    }

    @DeleteMapping("/job/{job_id}")
    public void deleteOne(@PathVariable int job_id){
            Job job = jobService.getOneJob(job_id);
            if (job != null) {
                jobService.deleteOneJob(job_id);
            } else {
                throw new Allexception(job_id);
            }

    }

    @PostMapping("/jobs")
    public Job addOne(@RequestBody Job job){
            jobService.addOneJob(job);

        return job;
    }

    @PutMapping("/job/{job_id}")
    public Job updateOne(@PathVariable int job_id,@RequestBody Job job){
            jobService.updateOneJob(job_id, job);

        Job job1 = jobService.getOneJob(job_id);
        return job1;
    }

    @PutMapping("/job/{job_id}/skills/")
    public Job updateSkill(@PathVariable int job_id, @RequestBody Skill skill){
        System.out.println("Skill add request in Job");
        Job job = jobService.updateSkillByJob(job_id,skill);
        return job;
    }

    @PutMapping("/job/{job_id}/application/")
    public Job updateSkill(@PathVariable int job_id, @RequestBody Application application){
        System.out.println("Skill add request in Job");
        Job job = jobService.updateApplicationByJob(job_id,application);
        return job;
    }

}


