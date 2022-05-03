package miu.edu.cs544.sirjana.jobsearch.repository;

import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.entity.ScreeningInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningInterviewRepository extends JpaRepository<ScreeningInterview, Integer>, JpaSpecificationExecutor<ScreeningInterview> {
}
