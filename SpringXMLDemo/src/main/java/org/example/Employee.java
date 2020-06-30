package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Employee {
    private int id;
    private String name, email;
    private Department department;
    private List<String> taskList;

    public Employee(int id, String name, String email, Department department) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }
    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }

    public String getInfo() {
        return "Id:" + id + "  name:" + name + " email:" + email + department+"\ntasklist:"+taskList;
    }


}