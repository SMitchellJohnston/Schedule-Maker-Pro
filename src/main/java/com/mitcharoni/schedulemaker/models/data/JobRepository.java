package com.mitcharoni.schedulemaker.models.data;

import com.mitcharoni.schedulemaker.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job,Integer> {
}
