package com.mitcharoni.schedulemaker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToMany(mappedBy = "jobs")
    private final List<Employee> employees = new ArrayList<>();

    @ManyToOne
    private Position position;

    private double payRate;

    public Job (){}

    public Job(Position position, double payRate){
        this.position = position;
        this.payRate = payRate;
    }



    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
