package miu.edu.cs544.sirjana.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Job implements Serializable {
    @Id
    @GeneratedValue
    private  int id;
    private String title;
    private float salary;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    private List<Skill> skills;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Application application;

    public Job(String title, float salary) {
        this.title = title;
        this.salary = salary;
    }

    public Job() {

    }



    public void setSkills(List<Skill> skills)
    {
        this.skills = skills;
    }

    public void setApplication(Application application)
    {
        this.application = application;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Application getApplication() {
        return application;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                ", application=" + application +
                '}';
    }
}
