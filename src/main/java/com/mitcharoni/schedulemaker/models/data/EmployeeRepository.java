package com.mitcharoni.schedulemaker.models.data;

import com.mitcharoni.schedulemaker.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
