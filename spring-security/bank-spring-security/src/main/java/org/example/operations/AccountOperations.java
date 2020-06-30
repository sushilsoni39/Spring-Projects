package org.example.operations;

import org.example.model.Account;

public interface AccountOperations {

    String creditAccount(long accNo, double amount);

    String  debitAccount(long accNo, double amount);

    Account getAccountDetails(int customerId);

    void deleteAccount(long accNo);
}
