package miu.edu.cs544.sirjana.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn(name = "C_Type")
public abstract class Company {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonManagedReference
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Job> jobs;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Company() {

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

    public Address getAddress() {
        return address;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", jobs=" + jobs +
                '}';
    }
}
