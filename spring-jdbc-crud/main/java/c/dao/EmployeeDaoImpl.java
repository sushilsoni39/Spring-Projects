package c.dao;

import c.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Employee employee) {
        String sql = "insert into employee(name,department) values (?,?)";

        try {

            int counter = jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getDepartment()});
            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }


    }

    @Override
    public List<Employee> read() {
        List<Employee> employeeList = jdbcTemplate.query("SELECT * FROM EMPLOYEE", new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();

                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));

                return employee;
            }

        });

        return employeeList;
    }


    @Override
    public List<Employee> findEmployeeById(int employeeId) {
        List<Employee> employeeList = jdbcTemplate.query("SELECT * FROM employee where id=?", new Object[]{employeeId}, new RowMapper<Employee>() {

                    @Override
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Employee employee = new Employee();

                        employee.setId(rs.getInt("id"));
                        employee.setName(rs.getString("name"));
                        employee.setDepartment(rs.getString("department"));

                        return employee;
                    }

                });

        return employeeList;
    }

    @Override
    public int update(Employee employee) {
        String sql = "update  employee set name=?, department=? where id=?";
        try {

            int counter = jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getDepartment(), employee.getId()});

            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int employeeId) {
        String sql = "delete from employee where id=?";

        try {

            int counter = jdbcTemplate.update(sql, new Object[]{employeeId});

            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
