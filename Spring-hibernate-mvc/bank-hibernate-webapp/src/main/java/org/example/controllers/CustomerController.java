package org.example.controllers;

import org.example.dao.*;
import org.example.model.*;
import org.example.exception.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller

// This class will be responsible for controlling the customer
@RequestMapping("/customer")
public class CustomerController {
    private CustomerDao customerDao;
    private SessionFactory sessionFactory;


    public CustomerController() {
        customerDao = new CustomerDao();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/config.xml");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Customer> showCustomers() {
        return customerDao.read();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Customer addCustomer(@RequestBody Customer customer) {
        return customerDao.create(customer);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody Customer removeCustomer(@RequestBody int customerId) {
        Session session = getSession();
        session.beginTransaction();
        Customer customer = (Customer) session.get( Customer.class,customerId);
        session.close();
        if(customer == null) {
            throw new CustomException("No customer found with this id  :: " + customerId);
        }
        return customerDao.delete(customerId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody Customer updateCustomer(@RequestBody Customer dummyUpdateCustomer) {
        Session session = getSession();
        session.beginTransaction();
        Customer customer = (Customer) session.get(Customer.class,dummyUpdateCustomer.getId());
        if(customer == null) {
            session.close();
            throw new CustomException("No customer with this id is present : " + dummyUpdateCustomer);
        }
        return customerDao.update(dummyUpdateCustomer);
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }
}
