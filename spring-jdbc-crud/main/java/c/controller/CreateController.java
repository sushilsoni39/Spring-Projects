package c.controller;
import c.model.Employee;
import c.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createEmployee(@RequestParam("name") String name,
                                       @RequestParam("department") String department , ModelAndView mv) {

        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);


        int counter = employeeDao.create(employee);

        if (counter > 0) {
            mv.addObject("msg", "Employee registration successful.");
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("create");

        return mv;
    }

}
