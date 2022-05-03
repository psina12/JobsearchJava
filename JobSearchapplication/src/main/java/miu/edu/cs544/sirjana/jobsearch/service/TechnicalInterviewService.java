package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.TechnicalInterview;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.TechnicalInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalInterviewService {
    @Autowired
    TechnicalInterviewRepository technicalinterviewrepository;

    public List<TechnicalInterview> getAllTechnicalInterviews()
    {
        return technicalinterviewrepository.findAll();

    }


    public TechnicalInterview getOneTechnicalInterview(int id){
        if(!technicalinterviewrepository.findById(id).isEmpty()){
            return technicalinterviewrepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }

    public TechnicalInterview updateOneTechnicalInterview(int id, TechnicalInterview technicalInterview){
        if(!technicalinterviewrepository.findById(id).isEmpty()) {
            technicalinterviewrepository.save(technicalInterview);
            TechnicalInterview technicalInterview1 = technicalinterviewrepository.getById(id);
            return technicalInterview;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneTechnicalInterview(TechnicalInterview technicalInterview){
        technicalinterviewrepository.save(technicalInterview);
        return "ScreeningInterview added";
    }

    public TechnicalInterview deleteOneTechnicalInterview(int id){
        if(!technicalinterviewrepository.findById(id).isEmpty()) {
            TechnicalInterview technicalInterview = technicalinterviewrepository.findById(id).get();
            technicalinterviewrepository.deleteById(id);
            return technicalInterview;
        }else{
            throw new Allexception(id);
        }
    }
}


