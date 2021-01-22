package com.mitcharoni.schedulemaker.models.dto;

import com.mitcharoni.schedulemaker.models.Job;
import com.mitcharoni.schedulemaker.models.Position;

import javax.validation.constraints.NotNull;

public class JobPositionDTO {

    @NotNull
    private Job job;

    @NotNull
    private Position position;

    @NotNull
    private Integer employeeId;

    public JobPositionDTO() {}

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
