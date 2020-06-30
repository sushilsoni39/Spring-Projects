package org.example.operations;

import org.example.model.*;

import java.util.List;

public interface CustomerOperations {

    long createCustomer(Customer customer, String branchCode);

    Customer getCustomerDetails(long accNo);

    Customer updateCustomerDetails(Customer customer, int id);

    void deleteCustomer(int id);


}
