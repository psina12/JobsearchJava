package miu.edu.cs544.sirjana.jobsearch.service;
import miu.edu.cs544.sirjana.jobsearch.entity.HiringManagerInterview;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.HiringManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringManagerService {

    @Autowired
    HiringManagerRepository hiringManagerRepository;

    public List<HiringManagerInterview> getAllHiringManagerInterviews()
    {
        return hiringManagerRepository.findAll();

    }


    public HiringManagerInterview getOneHiringManagerInterview(int id){
        if(!hiringManagerRepository.findById(id).isEmpty()){
            return hiringManagerRepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }


    public HiringManagerInterview deleteOneHiringManagerInterview(int id){
        if(!hiringManagerRepository.findById(id).isEmpty()) {
            HiringManagerInterview HiringManagerInterview = hiringManagerRepository.findById(id).get();
            hiringManagerRepository.deleteById(id);
            return HiringManagerInterview;
        }else{
            throw new Allexception(id);
        }
    }
    public HiringManagerInterview updateOneHiringManagerInterview(int id, HiringManagerInterview HiringManagerInterview){
        if(!hiringManagerRepository.findById(id).isEmpty()) {
            hiringManagerRepository.save(HiringManagerInterview);
            HiringManagerInterview HiringManagerInterview1 = hiringManagerRepository.getById(id);
            return HiringManagerInterview1;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneHiringManagerInterview(HiringManagerInterview HiringManagerInterview){
        hiringManagerRepository.save(HiringManagerInterview);
        return "HiringManagerInterview added";
    }
}

