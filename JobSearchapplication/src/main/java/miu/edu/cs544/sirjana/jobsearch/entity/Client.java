package miu.edu.cs544.sirjana.jobsearch.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
public class Client extends Company{


    private String mission;
    private String reason;
    private String website;


    public Client(String name, Address address, String mission, String reason, String website) {
        super(name, address);
        this.mission = mission;
        this.reason = reason;
        this.website = website;
    }

    public Client() {

    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Client{" +
                "mission='" + mission + '\'' +
                ", reason='" + reason + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
