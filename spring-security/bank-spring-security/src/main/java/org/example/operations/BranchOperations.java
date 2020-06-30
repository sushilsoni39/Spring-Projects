package org.example.operations;

import org.example.model.Branch;
import org.example.model.Customer;
import java.util.List;

public interface BranchOperations {

    Branch createBranch(Branch branch);

    void deleteBranch(String code);

    List<Customer> getAllCustomers(String branchCode);

}
