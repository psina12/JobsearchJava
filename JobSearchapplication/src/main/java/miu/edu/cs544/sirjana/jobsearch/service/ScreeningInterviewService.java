package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.Recruiter;
import miu.edu.cs544.sirjana.jobsearch.entity.ScreeningInterview;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.ScreeningInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningInterviewService {
    @Autowired
    ScreeningInterviewRepository screeninginterviewrepository;

    public List<ScreeningInterview> getAllScreeningInterview()
    {
        return screeninginterviewrepository.findAll();

    }


    public ScreeningInterview getOneScreeningInterview(int id){
        if(!screeninginterviewrepository.findById(id).isEmpty()){
            return screeninginterviewrepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }

    public ScreeningInterview updateOneScreeningInterview(int id, ScreeningInterview screeningInterview){
        if(!screeninginterviewrepository.findById(id).isEmpty()) {
            screeninginterviewrepository.save(screeningInterview);
            ScreeningInterview screeningInterview1 = screeninginterviewrepository.getById(id);
            return screeningInterview1;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneScreeningInterview(ScreeningInterview screeningInterview){
        screeninginterviewrepository.save(screeningInterview);
        return "ScreeningInterview added";
    }

    public ScreeningInterview deleteOneScreeningInterview(int id){
        if(!screeninginterviewrepository.findById(id).isEmpty()) {
            ScreeningInterview screeningInterview = screeninginterviewrepository.findById(id).get();
            screeninginterviewrepository.deleteById(id);
            return screeningInterview;
        }else{
            throw new Allexception(id);
        }
    }
}

