package com.mitcharoni.schedulemaker.controllers;

import com.mitcharoni.schedulemaker.models.Employee;
import com.mitcharoni.schedulemaker.models.Job;
import com.mitcharoni.schedulemaker.models.data.EmployeeRepository;
import com.mitcharoni.schedulemaker.models.data.JobRepository;
import com.mitcharoni.schedulemaker.models.data.PositionRepository;
import com.mitcharoni.schedulemaker.models.dto.EmployeeJobDTO;
import com.mitcharoni.schedulemaker.models.dto.EmployeeTitleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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

        Optional result = employeeRepository.findById(employeeId);
//        model.addAttribute("jobs", jobRepository.findAll());

        if (result.isPresent()){
            Employee employee = (Employee) result.get();
            model.addAttribute("employee", employee);
            model.addAttribute("jobs",employee.getJobs());
        }
        return "employee/viewEmployee";
    }

    @GetMapping("createJob")
    public String displayCreateJobForm(Model model, @RequestParam Integer employeeId) {

        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = result.get();
        model.addAttribute("title", "Create New Job for: " + employee.getFirstName() + " " + employee.getLastName());
        model.addAttribute("positions", positionRepository.findAll());
        model.addAttribute("jobs",employee.getJobs());
        model.addAttribute("employee",employee);
        EmployeeJobDTO employeeJob = new EmployeeJobDTO();
        employeeJob.setEmployee(employee);
        model.addAttribute("employeeJob",employeeJob);

        return "employee/createJob";
    }

    @PostMapping("createJob")
    public String processCreateJobForm(Model model,
                                       @ModelAttribute @Valid EmployeeJobDTO employeeJob,
                                       Errors errors ) {


        if (!errors.hasErrors()) {
            Employee dtoEmployee = employeeJob.getEmployee();
            Optional<Employee> result = employeeRepository.findById(dtoEmployee.getId());
            Job job = employeeJob.getJob();
            Employee employee = (Employee) result.get();
            if (!dtoEmployee.getJobs().contains(job)) {
                employee.addJob(job);
                if(employee.getMainTitle() == null){
                    employee.setMainTitle(job.toString());
                }
                employeeRepository.save(employee);
            }
            return "redirect:viewEmployee/" + employee.getId();
        }
        return "redirect:createJob?employeeId=" + employeeJob.getEmployee().getId();
    }

    @GetMapping("setMainTitle")
    public String displaySetMainTitleForm(Model model, @RequestParam Integer employeeId){
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = (Employee) result.get();
        EmployeeTitleDTO employeeTitle = new EmployeeTitleDTO();
        employeeTitle.setEmployee(employee);
        model.addAttribute("title", "Set Title");
        model.addAttribute("employee", employee);
        model.addAttribute("jobs", employee.getJobs());
        model.addAttribute("employeeTitle", employeeTitle);

        return "employee/setMainTitle";
    }

    @PostMapping("setMainTitle")
    public String processSetMainTitleForm(Model model, @ModelAttribute @Valid EmployeeTitleDTO employeeTitle){
        Employee employee = employeeTitle.getEmployee();
        String title = employeeTitle.getPosition().toString();
        if(employee.getMainTitle() == null){
            employee.setMainTitle(title);
        }
        employeeRepository.save(employee);
        return "redirect:viewEmployee/" + employee.getId();
    }

}

