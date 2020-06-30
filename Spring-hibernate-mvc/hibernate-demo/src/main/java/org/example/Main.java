package org.example;

import org.example.controller.EmployeeController;

public class Main {

    public static void main(String[] args) {
        EmployeeController hibernateController = new EmployeeController();
        hibernateController.performOperations();
    }
}