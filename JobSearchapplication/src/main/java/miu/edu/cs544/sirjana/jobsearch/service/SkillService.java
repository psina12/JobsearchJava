package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.entity.ScreeningInterview;
import miu.edu.cs544.sirjana.jobsearch.entity.Skill;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillrepository;

    public List<Skill> getAllSkill()
    {
        return skillrepository.findAll();

    }


    public Skill getOneSkill(int id){
        if(!skillrepository.findById(id).isEmpty()){
            return skillrepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }

    public Skill updateOneSkill(int id, Skill Skill){
        if(!skillrepository.findById(id).isEmpty()) {
            skillrepository.save(Skill);
            Skill skill1 = skillrepository.getById(id);
            return Skill;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneSkill(Skill skill){
        skillrepository.save(skill);
        return "ScreeningInterview added";
    }


    public Skill deleteOneSkill(int id){
        if(!skillrepository.findById(id).isEmpty()) {
            Skill skill = skillrepository.findById(id).get();
            skillrepository.deleteById(id);
            return skill;
        }else{
            throw new Allexception(id);
        }
    }
}

