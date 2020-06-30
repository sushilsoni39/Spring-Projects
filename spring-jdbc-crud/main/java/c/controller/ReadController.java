package c.controller;
import c.model.Employee;
import c.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ReadController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/read")
    public ModelAndView readStudent(ModelAndView model) throws IOException {

        List<Employee> listEmloyee = employeeDao.read();
        model.addObject("listEmployee", listEmloyee);
        model.setViewName("read");

        return model;
    }

}
