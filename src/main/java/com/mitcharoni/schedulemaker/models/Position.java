package com.mitcharoni.schedulemaker.models;

import com.mitcharoni.schedulemaker.models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Position extends AbstractEntity {


    @OneToMany(mappedBy = "position")
    private final List<Job> jobs = new ArrayList<>();

    @NotNull
    @NotBlank(message = "Position must have title")
    private String title;

    public Position(String title){
        this.title=title;
    }

    public Position(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return title;
    }
}
