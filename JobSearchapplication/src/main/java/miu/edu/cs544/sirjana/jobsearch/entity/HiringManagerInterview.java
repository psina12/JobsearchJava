package miu.edu.cs544.sirjana.jobsearch.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class HiringManagerInterview extends Interview{

    private LocalDate start_date;
    private int team_size;

    public HiringManagerInterview(LocalDate interview_date, String phoneNumber, String email_id,LocalDate start_date, int team_size) {
        super(interview_date, phoneNumber, email_id);
        this.start_date = start_date;
        this.team_size = team_size;
    }

    public HiringManagerInterview() {

    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public int getTeam_size() {
        return team_size;
    }

    public void setTeam_size(int team_size) {
        this.team_size = team_size;
    }

    @Override
    public String toString() {
        return "HiringManagerInterview{" +
                "start_date=" + start_date +
                ", team_size=" + team_size +
                '}';
    }
}
