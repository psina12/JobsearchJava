package miu.edu.cs544.sirjana.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import miu.edu.cs544.sirjana.jobsearch.service.JobService;

import javax.persistence.*;

@Entity
public class Skill {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float experience;
    private String description;
    private String language;

    @ManyToOne
    @JsonBackReference
    @JoinTable(name="Skill_Job",
            joinColumns={@JoinColumn(name="skill_id")},
            inverseJoinColumns={@JoinColumn(name="job_id")})
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
