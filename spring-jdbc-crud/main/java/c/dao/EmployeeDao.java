package c.dao;

import c.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public int create(Employee employee);

    public List<Employee> read();

    public List<Employee> findEmployeeById(int employeeId);

    public int update(Employee employee);

    public int delete(int employeeId);

}
