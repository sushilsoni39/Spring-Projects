package org.example.dao;

import org.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class EmployeeDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void exit() {
        sessionFactory.close();
    }


    private void create() {
        Employee employee = new Employee();
        employee.setName("Sushil");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();
    }

    private List<Employee> read() {
        Session session = this.sessionFactory.openSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        session.close();
        return employeeList;
    }

    private void update() {
        Employee employee = new Employee();
        employee.setName("Roja");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee oldEmployee = (Employee) session.load(Employee.class, 1);
        oldEmployee.setName(employee.getName());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + oldEmployee);
    }

    private void delete() {
        Employee employee = new Employee();
        System.out.println("Enter the id of employee to be deleted\n");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        employee.setId(id);
        @SuppressWarnings("unchecked")
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(employee);

        session.getTransaction().commit();
        session.close();
    }

    public void performOperations() {
        Scanner sc = new Scanner(System.in);
        create();
        while (true) {
            int option;
            System.out.println("Enter your choice : ");
            System.out.println(" 1. Create \n 2. read\n 3. Update\n 4. Delete\n 5. Exit\n");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    exit();
                    return;
                default:
                    System.out.println("Please enter a valid option\n");
            }
        }
    }
}
