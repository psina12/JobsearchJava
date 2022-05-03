package miu.edu.cs544.sirjana.jobsearch.repository;

import miu.edu.cs544.sirjana.jobsearch.entity.Application;
import miu.edu.cs544.sirjana.jobsearch.entity.HiringManagerInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringManagerRepository extends JpaRepository<HiringManagerInterview, Integer>, JpaSpecificationExecutor<HiringManagerInterview> {

}
