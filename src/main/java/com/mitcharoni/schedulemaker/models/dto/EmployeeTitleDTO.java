package com.mitcharoni.schedulemaker.models.dto;

import com.mitcharoni.schedulemaker.models.Employee;
import com.mitcharoni.schedulemaker.models.Job;
import com.mitcharoni.schedulemaker.models.Position;

import javax.validation.constraints.NotNull;

public class EmployeeTitleDTO {

    @NotNull
    private Employee employee;

    @NotNull
    private Position position;


    public EmployeeTitleDTO() {}

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
