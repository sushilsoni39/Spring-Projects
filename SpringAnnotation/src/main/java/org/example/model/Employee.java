package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    public void init(){
        System.out.println("Employee Init");
    }


    @Value("${id}")
    int id;
    @Value("${name}")
    String name;
    @Value("${email}")
    String email;

    @Autowired
    private Department department;

   public Employee() {

    }

    public void setId(int id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    @Autowired
    public void setDepartment(Department department)
    {
        this.department=department;
    }
    @Override
    public String toString() {
        return "EmployeeDetails:\n" + "id: "+id+
                "\nName:" + name + "\nemail:"+email+"\nDepartment:" + department;
    }

    public void destroy(){
        System.out.println("Employee Destroy");
    }

}