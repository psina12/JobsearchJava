package miu.edu.cs544.sirjana.jobsearch.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance
@DiscriminatorColumn(name = "I_Type")
public abstract class Interview {

    @Id
    @GeneratedValue
    private int id;
    private LocalDate interview_date;
    private String phoneNumber;
    private String email_id;


    @ManyToOne
    @JoinColumn
    private Application application;

    public Interview(LocalDate interview_date, String phoneNumber, String email_id) {
        this.interview_date = interview_date;
        this.phoneNumber = phoneNumber;
        this.email_id = email_id;
    }

    public Interview() {

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public int getId() {
        return id;
    }

    public LocalDate getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(LocalDate interview_date) {
        this.interview_date = interview_date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public Application getApplication() {
        return application;
    }

}
