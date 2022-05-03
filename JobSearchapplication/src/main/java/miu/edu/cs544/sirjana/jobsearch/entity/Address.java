package miu.edu.cs544.sirjana.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String state;
    private String city;


    @OneToOne
    @JoinColumn
	@JsonBackReference
    private  Company company;

    public Address(String street, String state, String city, Company company) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.company = company;
    }

    public Address() {

    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", company=" + company +
                '}';
    }
}
