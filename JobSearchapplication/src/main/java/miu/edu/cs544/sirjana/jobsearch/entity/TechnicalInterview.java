package miu.edu.cs544.sirjana.jobsearch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TechnicalInterview extends Interview{

    private int duration;
    private Location location;

    private String questions;


    public TechnicalInterview(LocalDate interview_date, String phoneNumber, String email_id, int duration, Location location, String questions) {
        super(interview_date, phoneNumber, email_id);
        this.duration = duration;
        this.location = location;
        this.questions = questions;
    }

    public TechnicalInterview() {

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
