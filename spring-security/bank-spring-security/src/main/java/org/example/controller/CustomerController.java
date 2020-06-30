package org.example.controller;

import org.example.dao.CustomerDao;
import org.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableTransactionManagement(proxyTargetClass = true)
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerDao dao;

    @PostMapping(value = "/{branchCode}")
    public long addCustomer(@RequestBody Customer customer,@PathVariable String branchCode){
        return dao.createCustomer(customer,branchCode);
    }

    @GetMapping(value = "/{accNo}")
    public Customer getCustomer(@PathVariable long accNo)
    {
        return dao.getCustomerDetails(accNo);
    }

    @PutMapping(value = "/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer)
    {
        return dao.updateCustomerDetails(customer,id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteCustomer(@PathVariable int id){
        dao.deleteCustomer(id);
        return "deleted customer with id:"+id+" and associated account";
    }


}
