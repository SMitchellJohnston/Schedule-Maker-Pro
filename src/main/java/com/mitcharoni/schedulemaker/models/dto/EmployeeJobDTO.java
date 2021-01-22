package com.mitcharoni.schedulemaker.models.dto;

import com.mitcharoni.schedulemaker.models.Employee;
import com.mitcharoni.schedulemaker.models.Job;

import javax.validation.constraints.NotNull;

public class EmployeeJobDTO {

    @NotNull
    private Employee employee;

    @NotNull
    private Job job;

    public EmployeeJobDTO(){}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
