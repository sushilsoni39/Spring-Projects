package com.model;



public class Employee {
    private String empId;
    private String empName;
    private String empCity;
    private int empAge;
    private String empDept;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Employee() {
    }

    public Employee(String empID,String empName, String empCity, int empAge, String empDept) {
        this.empId=empID;
        this.empName = empName;
        this.empCity = empCity;
        this.empAge = empAge;
        this.empDept = empDept;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }
}
