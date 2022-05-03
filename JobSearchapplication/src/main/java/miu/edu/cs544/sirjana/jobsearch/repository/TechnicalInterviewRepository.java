package miu.edu.cs544.sirjana.jobsearch.repository;

import miu.edu.cs544.sirjana.jobsearch.entity.TechnicalInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalInterviewRepository extends JpaRepository<TechnicalInterview,Integer>, JpaSpecificationExecutor<TechnicalInterview> {
}
