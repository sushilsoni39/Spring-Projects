package c.controller;
import java.io.IOException;

import c.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/delete/{employeeId}")
    public ModelAndView deleteStudentById(ModelAndView mv, @PathVariable("employeeId") int employeeId)
            throws IOException {

        int counter = employeeDao.delete(employeeId);

        if (counter > 0) {
            mv.addObject("msg", "Employee records deleted against Employee id: " + employeeId);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("delete");

        return mv;
    }
}
