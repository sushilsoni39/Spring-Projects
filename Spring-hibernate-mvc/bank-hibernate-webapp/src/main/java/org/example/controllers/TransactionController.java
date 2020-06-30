package org.example.controllers;
import org.example.dao.TransactionDao;
import org.example.exception.CustomException;
import org.example.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    private TransactionDao transactionDao;
    protected SessionFactory sessionFactory;

    public TransactionController() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/config.xml");
    }

    @RequestMapping(value = "/debit", method = RequestMethod.POST)
    public @ResponseBody void debitBalance(@RequestBody String accountNumber,@RequestBody long withdrawAmount) {
        Session session = getSession();
        session.beginTransaction();
        Account account = (Account) session.get(Account.class,accountNumber);
        session.close();
        if (account == null) {
            throw new CustomException("No Account with this id is present : " + accountNumber);
        }
        if (account.getBalance() < withdrawAmount) {
            throw new CustomException("!!! Not Enough balance in account ");
        }
         transactionDao.withdraw(withdrawAmount,accountNumber);
    }

    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public @ResponseBody void creditBalance(@RequestBody String accountNumber,@RequestBody long depositAmount) {
        Session session = getSession();
        session.beginTransaction();
        Account account = (Account) session.get(Account.class, accountNumber);
        session.close();
        if(account == null) {
            throw new CustomException("No account with this id is present : " + accountNumber);
        }
         transactionDao.deposit(depositAmount,accountNumber);
    }


    private Session getSession() {
        return sessionFactory.openSession();
    }
}
