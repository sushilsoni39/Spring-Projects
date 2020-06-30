package c.controller;

import java.io.IOException;
import java.util.List;

import c.model.Employee;
import c.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/update/{employeeId}")
    public ModelAndView findEmployeeById(ModelAndView model, @PathVariable("employeeId") int employeeId)
            throws IOException {

        List<Employee> listEmployee = employeeDao.findEmployeeById(employeeId);
        model.addObject("listEmployee", listEmployee);
        model.setViewName("update");

        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@RequestParam("id") int id, @RequestParam("name") String name,
                                       @RequestParam("department") String department, ModelAndView mv) {

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setDepartment(department);

        int counter = employeeDao.update(employee);

        if (counter > 0) {
            mv.addObject("msg", "Employee records updated against employee id: " + employee.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("update");

        return mv;
    }
}