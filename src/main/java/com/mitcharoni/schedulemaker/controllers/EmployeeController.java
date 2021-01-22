package com.mitcharoni.schedulemaker.controllers;

import com.mitcharoni.schedulemaker.models.Employee;
import com.mitcharoni.schedulemaker.models.Job;
import com.mitcharoni.schedulemaker.models.Position;
import com.mitcharoni.schedulemaker.models.data.EmployeeRepository;
import com.mitcharoni.schedulemaker.models.data.JobRepository;
import com.mitcharoni.schedulemaker.models.data.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("employee")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public String displayEmployees(Model model) {
        model.addAttribute("employees",employeeRepository.findAll());
        model.addAttribute("positions", positionRepository.findAll());
        return "employee/index";
    }

    @GetMapping("create")
    public String displayCreateEmployeeForm(Model model) {
        model.addAttribute("title", "Create New Employee");
        model.addAttribute(new Employee());
        return "employee/create";
    }

    @PostMapping("create")
    public String processCreateEmployerForm(@ModelAttribute("employee") @Valid Employee newEmployee, Errors errors,
                                            Model model) {

        if(errors.hasErrors()){
            model.addAttribute("title", "Create New Employee");
        }
        employeeRepository.save(newEmployee);
        return "redirect:viewEmployee/" + newEmployee.getId();
    }

    @GetMapping("viewEmployee/{employeeId}")
    public String displayViewEmployee(Model model, @PathVariable int employeeId) {

        Optional optEmployee = employeeRepository.findById(employeeId);
//        model.addAttribute("jobs", jobRepository.findAll());

        if (optEmployee.isPresent()){
            Employee employee = (Employee) optEmployee.get();
            model.addAttribute("employee", employee);
            model.addAttribute("jobs",employee.getJobs());
        }
        return "employee/viewEmployee";
    }
}
