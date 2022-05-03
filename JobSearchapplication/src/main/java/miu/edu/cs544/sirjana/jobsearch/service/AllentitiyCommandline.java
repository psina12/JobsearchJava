package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.repository.ApplicationRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.CompanyRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.InterviewRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AllentitiyCommandline implements CommandLineRunner {

    @Autowired
    JobRepository jobRepository;

//    @Autowired
//    InterviewRepository interviewRepository;
//
//    @Autowired
//    CompanyRepository companyRepository;
//
//    @Autowired
//    ApplicationRepository applicationRepository;

    @Override
    public void run(String... args) throws Exception {

       // System.out.println(jobRepository.findByTitle("Software Developer"));

   //System.out.println(studentRepository.findByName("jack")); // this one is from studentRepository
        //System.out.println(studentRepository.findByNameAndGpa("Jim",3.0f));
        //  System.out.println(studentRepository.findAll());
        // System.out.println(jobRepository.findById(2));

       // System.out.println(ApplicationRepository.findByResume_versions(2.2f));

      //  System.out.println(ApplicationRepository.getJobsWithApplication("QA Tester"));

        //System.out.println(studentRepository.findStudentsThatPassed(3.2f));

        //System.out.println(studentRepository.findFailing());
        //System.out.println(studentRepository.findStudentsThatPassed(2.5f));

       // System.out.println(studentRepository.findAll(StudentSpecification.hasGpaMoreThan(2.5f)));
        //  studentRepository.findAll(hasGpaGreaterThan(3.0f ));


    }
}
