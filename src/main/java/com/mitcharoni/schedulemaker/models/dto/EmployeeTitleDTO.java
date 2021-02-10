package com.mitcharoni.schedulemaker.models.dto;

import com.mitcharoni.schedulemaker.models.Employee;
import com.mitcharoni.schedulemaker.models.Job;
import com.mitcharoni.schedulemaker.models.Position;

import javax.validation.constraints.NotNull;

public class EmployeeTitleDTO {

    @NotNull
    private Employee employee;

    @NotNull
    private String mainTitle;


    public EmployeeTitleDTO() {}

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
