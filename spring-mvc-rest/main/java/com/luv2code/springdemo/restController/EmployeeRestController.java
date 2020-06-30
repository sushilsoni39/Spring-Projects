package com.luv2code.springdemo.restController;

import com.luv2code.springdemo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private List<Employee> employeeList=new ArrayList<>();

    @PostConstruct
    public void loadData()
    {
        employeeList.add(new Employee(0,"Sushil","PTO"));
        employeeList.add(new Employee(1,"Roja","FAWB"));
        employeeList.add(new Employee(2,"Romi","DMS"));
    }
    @GetMapping("/employee")
    public List<Employee> getEmployees()
    {
        return employeeList;
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId)
    {
        return employeeList.get(employeeId);
    }
}
