package miu.edu.cs544.sirjana.jobsearch.repository;

import miu.edu.cs544.sirjana.jobsearch.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer>, JpaSpecificationExecutor<Skill> {

}
