package org.example.dao;

import org.example.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AccountDao {

    protected SessionFactory sessionFactory;

    private void setup() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    private void exit() {
        sessionFactory.close();
    }

    private void create() {
        Account account = new Account();

        System.out.println("Enter the account no. of Customer \n");
        Scanner scanner1 = new Scanner(System.in);
        String accountNumber = scanner1.nextLine();
        account.setAccountNumber(accountNumber);

        System.out.println("Enter the type of Customer \n");
        Scanner scanner2 = new Scanner(System.in);
        String type = scanner2.nextLine();
        account.setType(type);

        System.out.println("Enter the inital balance of account\n");
        Scanner scanner3 = new Scanner(System.in);
        long balance = scanner3.nextLong();
        account.setBalance(balance);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }

    private void read() {
        Session session = sessionFactory.openSession();
        System.out.println(session.createQuery("FROM Account").list() + "\n");
        session.close();
    }

    private void update(String type) {
        Account account = new Account();

        System.out.println("Enter the account no. of customer to be updated\n");
        Scanner scanner1 = new Scanner(System.in);
        String accountNo = scanner1.nextLine();
        account.setAccountNumber(accountNo);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account oldAccount = (Account) session.load(Account.class, accountNo);
        account.setType(type);
        oldAccount.setType(account.getType());
        session.getTransaction().commit();
        session.close();
    }

    private void delete() {
        Account account = new Account();
        System.out.println("Enter the account no. of customer to be deleted\n");
        Scanner scanner = new Scanner(System.in);
        String accountNo = scanner.nextLine();
        account.setAccountNumber(accountNo);
        @SuppressWarnings("unchecked")
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }


}
