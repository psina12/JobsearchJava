package miu.edu.cs544.sirjana.jobsearch.controller;
import miu.edu.cs544.sirjana.jobsearch.entity.Skill;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skills")
    public List<Skill> getAll(){

        return skillService.getAllSkill();

    }


    @GetMapping("/skill/{skill_id}")
    public Skill getOne(@PathVariable int skill_id){
        Skill skill = skillService.getOneSkill(skill_id);
        if (skill == null) {
            throw new Allexception(skill_id);
        }
        return skill;

    }

    @DeleteMapping("/skill/{skill_id}")
    public void deleteOne(@PathVariable int skill_id){
        Skill skill = skillService.getOneSkill(skill_id);
        if (skill != null) {
            skillService.deleteOneSkill(skill_id);
        } else {
            throw new Allexception(skill_id);
        }

    }

    @PostMapping("/skills")
    public Skill addOne(@RequestBody Skill skill){
        skillService.addOneSkill(skill);

        return skill;
    }

    @PutMapping("/skill/{skill_id}")
    public Skill updateOne(@PathVariable int skill_id,@RequestBody Skill skill){
        skillService.updateOneSkill(skill_id, skill);

        Skill skill1 = skillService.getOneSkill(skill_id);
        return skill1;
    }
}

