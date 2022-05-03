package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.*;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.ApplicationRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.HiringManagerRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.ScreeningInterviewRepository;
import miu.edu.cs544.sirjana.jobsearch.repository.TechnicalInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationrepository;

    @Autowired
    HiringManagerRepository hiringManagerRepository;

    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;

    @Autowired
    TechnicalInterviewRepository technicalInterviewRepository;

    public List<Application> getAllApplication() {
        return applicationrepository.findAll();

    }


    public Application getOneApplication(int id) {
        if (!applicationrepository.findById(id).isEmpty()) {
            return applicationrepository.findById(id).get();
        } else {
            throw new Allexception(id);
        }
    }

    public Application updateOneApplication(int id, Application application) {
        if (!applicationrepository.findById(id).isEmpty()) {
            applicationrepository.save(application);
            Application application1 = applicationrepository.getById(id);
            return application1;
        } else {
            throw new Allexception(id);
        }
    }

    public String addOneApplication(Application application) {
        applicationrepository.save(application);
        return "Application added";
    }

    public Application deleteOneApplication(int id) {
        if (!applicationrepository.findById(id).isEmpty()) {
            Application application = applicationrepository.findById(id).get();
            applicationrepository.deleteById(id);
            return application;
        } else {
            throw new Allexception(id);
        }
    }


    public Application updateHiringInterviewFromApplication(int app_id, HiringManagerInterview hiringManagerInterview) {
        Optional<Application> application = applicationrepository.findById(app_id);
        if (!application.isEmpty()) {
            Application application1 = application.get();
            hiringManagerInterview.setApplication(application1);
            hiringManagerRepository.save(hiringManagerInterview);
            return application1;
        } else {
            throw new Allexception(app_id);
        }
    }

    public Application updateScreeningInterviewFromApplication(int app_id, ScreeningInterview screeningInterview) {
        Optional<Application> application = applicationrepository.findById(app_id);
        if (!application.isEmpty()) {
            Application application1 = application.get();
            screeningInterview.setApplication(application1);
            screeningInterviewRepository.save(screeningInterview);
            return application1;
        } else {
            throw new Allexception(app_id);
        }
    }

    public Application updateTechnicalInterviewFromApplication(int app_id, TechnicalInterview technicalInterview) {
        Optional<Application> application = applicationrepository.findById(app_id);
        if (!application.isEmpty()) {
            Application application1 = application.get();
            technicalInterview.setApplication(application1);
            technicalInterviewRepository.save(technicalInterview);
            return application1;
        } else {
            throw new Allexception(app_id);
        }
    }
}
















