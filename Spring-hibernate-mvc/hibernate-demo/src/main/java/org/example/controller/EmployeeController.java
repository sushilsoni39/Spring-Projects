package org.example.controller;

import org.example.model.Address;
import org.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class EmployeeController {

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
        Employee emp = new Employee();
        System.out.println("Enter the name of employee \n");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        emp.setName(name);
        System.out.println("Enter the salary of the employee\n");
        Scanner scanner2 = new Scanner(System.in);
        int salary = scanner1.nextInt();
        emp.setSalary(salary);
        Address address = new Address("10 Silver street", "NYC", "USA");
        emp.setAddress(address);


        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(emp);
        session.save(address);

        session.getTransaction().commit();
        session.close();
    }

    private void read() {
        Session session = sessionFactory.openSession();
        System.out.println(session.createQuery("FROM Employee").list()+"\n");
        session.close();
    }

    private void update() {
        Employee emp = new Employee();

        Address address = new Address("10 Silver street", "NYC", "USA");
        emp.setAddress(address);
        System.out.println("Enter the id of employee to be updated\n");
        Scanner scanner1 = new Scanner(System.in);
        int id = scanner1.nextInt();
        emp.setId(id);
        System.out.println("Enter the name of the employee\n");
        Scanner scanner2 = new Scanner(System.in);
        String name = scanner2.nextLine();
        emp.setName(name);
        System.out.println("Enter the salary of employee\n");
        Scanner scanner3 = new Scanner(System.in);
        int salary = scanner3.nextInt();
        emp.setSalary(salary);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee oldEmp = (Employee) session.load(Employee.class, id);
        oldEmp.setName(emp.getName());
        oldEmp.setSalary(emp.getSalary());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + oldEmp);
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
        setup();
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
