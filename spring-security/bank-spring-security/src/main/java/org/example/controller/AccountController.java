package org.example.controller;

import org.example.dao.AccountDao;
import org.example.dao.CustomerDao;
import org.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableTransactionManagement(proxyTargetClass = true)
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountDao dao;

    @PutMapping("/credit/{accNo}")
    public String creditAccount(@PathVariable long accNo,@RequestParam(value = "amount") double amount){
        return dao.creditAccount(accNo,amount);
    }

    @PutMapping("/debit/{accNo}")
    public String debitAccount(@PathVariable long accNo,@RequestParam(value = "amount") double amount){
        return dao.debitAccount(accNo,amount);
    }

    @GetMapping("/{customerId}")
    public Account getAccountDetails(@PathVariable int customerId)
    {
        return dao.getAccountDetails(customerId);
    }

    @DeleteMapping("/{accNo}")
    public void deleteAccount(@PathVariable Long accNo)
    {
        dao.deleteAccount(accNo);
    }
}
