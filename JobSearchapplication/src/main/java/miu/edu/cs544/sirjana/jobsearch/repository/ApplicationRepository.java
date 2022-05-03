package miu.edu.cs544.sirjana.jobsearch.repository;

import miu.edu.cs544.sirjana.jobsearch.entity.Application;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>, JpaSpecificationExecutor<Application> {

  //  public static Application findByResume_versions(Float resume_version);

    @Query(value = "select j.* FROM application as a inner join job as j on a.job_id=j.id", nativeQuery = true)
    public Job getJobsWithApplication(String title);

}
