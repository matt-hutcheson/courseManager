package com.codeclan.example.courseManager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @JsonBackReference
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Course> courses;

    @JsonBackReference
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Customer> customers;

    public Booking(String date, List<Course> courses, List<Customer> customers) {
        this.date = date;
        this.courses = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public Booking(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

