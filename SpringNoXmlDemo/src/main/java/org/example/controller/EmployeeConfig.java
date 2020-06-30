package org.example.controller;

import org.example.model.Department;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.Date;

@Configuration
@PropertySource("classpath:employeeDetails.properties")
@ComponentScan("org.example")
public class EmployeeConfig
{
    @Bean
    public Employee employee(@Autowired Department department){
        return new Employee(department);
    }

    @Bean
    public Department department(@Autowired Date date){
        Department d =  new Department();
        d.setDate(date);
        d.setDepartment("${department}");
        return d;

    }
    //DateConverter is implementing factory bean that means it is a special bean therefore we will make it as bean in  config file
    @Bean
    public DateFormatter createdOn(){
        return new DateFormatter();
    }

}