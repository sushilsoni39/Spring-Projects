package org.example.dao;

import org.example.exception.CustomException;
import org.example.model.*;
import org.example.operations.AccountOperations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDao implements AccountOperations {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public String creditAccount(long accNo, double amount) {
        Session session = sessionFactory.getCurrentSession();
        Query query1 = session.createQuery("select balance from Account where accountNo = :accNo");
        query1.setParameter("accNo",accNo);
        double bal = (Double) query1.getSingleResult();
        Query query = session.createQuery("update Account set balance = :bal where accountNo = :accNo");
        query.setParameter("bal",bal+amount);
        query.setParameter("accNo",accNo);
        query.executeUpdate();
        return "credited";
    }

    @Override
    @Transactional
    public String debitAccount(long accNo, double amount) {
        Session session = sessionFactory.getCurrentSession();
        Query query1 = session.createQuery("select balance from Account where accountNo = :accNo");
        query1.setParameter("accNo",accNo);
        double bal = (Double) query1.getSingleResult();
        if(amount>bal)
            throw new CustomException("insufficient balance");
        Query query = session.createQuery("update Account set balance = :bal where accountNo = :accNo");
        query.setParameter("bal",bal-amount);
        query.setParameter("accNo",accNo);
        query.executeUpdate();
        return "debited";
    }

    @Override
    @Transactional
    public Account getAccountDetails(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,customerId);
        if (customer==null)
            throw new CustomException("Customer Does not exist");
        Account account = customer.getAccount();
        return new Account(account.getAccountNo(),account.getBalance());
    }

    @Override
    @Transactional
    public void deleteAccount(long accNo) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.get(Account.class,accNo);
        if(account==null)
        {
            throw new CustomException("Account not found");
        }
        session.delete(account);
    }
}
