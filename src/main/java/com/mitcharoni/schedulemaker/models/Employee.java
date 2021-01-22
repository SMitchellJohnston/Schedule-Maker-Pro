package com.mitcharoni.schedulemaker.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Employee extends AbstractEntity {



    @ManyToMany
    private final List<Job> jobs = new ArrayList<>();

    @NotBlank
    @NotNull(message = "First name is required.")
    private String firstName;

    @NotBlank
    @NotNull(message = "Last name is required.")
    private String lastName;


    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Employee () {}

    public List<Job> getJobs() {
        return jobs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void addJob(Job job) {
        this.jobs.add(job);
    }




}
