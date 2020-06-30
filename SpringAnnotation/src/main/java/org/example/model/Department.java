package org.example.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class Department {

    @Value("${department}")
    private String department;
    @Autowired
    private Date createdOn;
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return
                "" + department + '\'' +
                ", createdOn=" + createdOn ;
    }
}