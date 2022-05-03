package miu.edu.cs544.sirjana.jobsearch.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Application {


    @Id
    @GeneratedValue
    private  int id;
    private LocalDate date;
    private float resume_version;

    @OneToOne
    private Job job;

    public Application(LocalDate date, float resume_version, Job job) {
        this.date = date;
        this.resume_version = resume_version;
        this.job = job;
    }

    public Application() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getResume_version() {
        return resume_version;
    }

    public void setResume_version(float resume_version) {
        this.resume_version = resume_version;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", date=" + date +
                ", resume_version=" + resume_version +
                ", job=" + job +
                '}';
    }
}
