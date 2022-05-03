package miu.edu.cs544.sirjana.jobsearch.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class ScreeningInterview extends  Interview{

    private String name;
    private String result;

    public ScreeningInterview(LocalDate interview_date, String phoneNumber, String email_id,String name, String result) {
        super(interview_date, phoneNumber, email_id);
        this.name = name;
        this.result = result;
    }

    public ScreeningInterview() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
