package org.example.controller;

import org.example.dao.BranchDao;
import org.example.dao.CustomerDao;
import org.example.model.Branch;
import org.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableTransactionManagement(proxyTargetClass = true)
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchDao dao;

    @PostMapping("/")
    public Branch addBranch(@RequestBody Branch branch)
    {
        return dao.createBranch(branch) ;
    }

    @GetMapping(value = "/{branchCode}")
    public List<Customer> getAllCustomers(@PathVariable String branchCode)
    {
        return dao.getAllCustomers(branchCode);
    }

    @DeleteMapping(value = "/{branchCode}")
    public void deleteBranch(@PathVariable String branchCode){
        dao.deleteBranch(branchCode);
    }

}
