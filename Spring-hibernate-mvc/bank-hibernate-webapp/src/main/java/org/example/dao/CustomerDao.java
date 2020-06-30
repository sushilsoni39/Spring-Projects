package org.example.dao;

import org.example.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDao {

    protected SessionFactory sessionFactory;

    private void setup() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    private void exit() {
        sessionFactory.close();
    }

    public Customer create(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setId(customer.getId());
        newCustomer.setName(customer.getName());
        newCustomer.setContactNo(customer.getContactNo());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(newCustomer);
        session.getTransaction().commit();
        session.close();
        return newCustomer;
    }

    public List<Customer> read() {
        Session session = sessionFactory.openSession();
        System.out.println(session.createQuery("FROM Customer").list()+"\n");
        session.close();
        return null;
    }

    public Customer update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer oldCustomer = (Customer) session.load(Customer.class, customer.getId());
        oldCustomer.setId(customer.getId());
        oldCustomer.setName(customer.getName());
        oldCustomer.setContactNo(customer.getContactNo());
        session.getTransaction().commit();
        session.close();
        return oldCustomer;
    }

    public Customer delete(int customerId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer oldCustomer = (Customer) session.load(Customer.class, customerId);
        session.delete(oldCustomer);
        session.getTransaction().commit();
        session.close();
        return oldCustomer;
    }


}
