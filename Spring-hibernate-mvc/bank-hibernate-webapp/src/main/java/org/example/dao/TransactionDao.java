package org.example.dao;

import org.example.exception.CustomException;
import org.example.model.Account;
import org.example.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransactionDao {
    private long withdrawAmount;
    private long depositAmount;
    private long netBalance;
    private static SessionFactory sessionFactory;

    public void deposit(long depositAmount,String AccountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account account = (Account) session.get(Account.class, AccountNumber);
        netBalance = account.getBalance() + depositAmount;
        account.setBalance(netBalance);
    }

    public Customer withdraw(long withdrawAmount, String AccountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account account = (Account) session.get(Account.class, AccountNumber);
        if (withdrawAmount > account.getBalance()) {
            throw new CustomException("low balance");
        }
        netBalance = account.getBalance() - depositAmount;
        account.setBalance(netBalance);
        return null;
    }

    public double getBalance(String AccountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account account = (Account) session.get(Account.class, AccountNumber);
        return account.getBalance();
    }

}



