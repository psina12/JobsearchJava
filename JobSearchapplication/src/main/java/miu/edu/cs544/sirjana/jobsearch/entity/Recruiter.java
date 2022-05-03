package miu.edu.cs544.sirjana.jobsearch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Recruiter extends Company{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Client> clients;


    public Recruiter(String name, Address address, List<Client> clients) {
        super(name, address);
        this.clients = clients;
    }

    public Recruiter() {

    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "clients=" + clients +
                '}';
    }
}
