package miu.edu.cs544.sirjana.jobsearch.repository;

import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>, JpaSpecificationExecutor<Job> {

//    @Query(value = "select j.* FROM application as a inner join job as j on a.job_id=j.id", nativeQuery = true)
//    public Job getJobsWithApplication(String title);


   // public List<Job> findById(int id);

    public List<Job> findByTitle(String title);



//    public List<Job> findJobsWithCompaniesInCertainState(String state);

//    @Query(value = "select j from Job as j where size(j.interviews) >= 2")
//    public List<Job> findJobsWithAtLeastTwoInterviews();


}
