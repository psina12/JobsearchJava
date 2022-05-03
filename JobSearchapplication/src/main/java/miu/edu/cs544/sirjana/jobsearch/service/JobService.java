package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.Application;
import miu.edu.cs544.sirjana.jobsearch.entity.Company;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.entity.Skill;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.ApplicationRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.CompanyRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.JobRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    CompanyRepository companyRepository;

    public List<Job> getAllJobs()
    {
        return jobRepository.findAll();

    }


    public Job getOneJob(int id){
        if(!jobRepository.findById(id).isEmpty()){
            return jobRepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }


    public Job deleteOneJob(int id){
        if(!jobRepository.findById(id).isEmpty()) {
            Job Job = jobRepository.findById(id).get();
            jobRepository.deleteById(id);
            return Job;
        }else{
            throw new Allexception(id);
        }
    }

    public Job updateOneJob(int id, Job job){
        if(!jobRepository.findById(id).isEmpty()) {
            jobRepository.save(job);
            Job job1 = jobRepository.getById(id);
            return job1;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneJob(Job job){
        jobRepository.save(job);
        return "Job added";
    }



    public Job updateSkillByJob(int job_id, Skill skill) {
        Optional<Job> job = jobRepository.findById(job_id);
        if (!job.isEmpty()) {
            skill.setJob(job.get());
            skillRepository.save(skill);
            return job.get();
        }else {
            throw new Allexception(job_id);
        }
    }


    public Job updateApplicationByJob(int job_id, Application application) {
        Optional<Job> job = jobRepository.findById(job_id);
        if (!job.isEmpty()) {
            application.setJob(job.get());
            applicationRepository.save(application);
            job.get().setApplication(application);
             jobRepository.save(job.get());
            return job.get();
        }else {
            throw new Allexception(job_id);
        }
    }


//    public Job updateCompanyByJob(int job_id, Company company) {
//        Optional<Job> job = jobRepository.findById(job_id);
//        if (!job.isEmpty()) {
//            company.setJobs(job.get());
//            companyRepository.save(company);
//            return job.get();
//        }else {
//            throw new Allexception(job_id);
//        }
//    }




}

//
//    public String addOneApplication(Application application){
//        applicationrepository.save(application);
//        return "Application added";
//    }
