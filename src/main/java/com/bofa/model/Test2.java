package com.bofa.model;

import com.bofa.model.Transaction;

public class Test2 {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(101, "Deposit", 5000.00, "BR001", 10000.00);


        System.out.println("Transaction 1 Details:");
        System.out.println(transaction1);


        Transaction transaction2 = new Transaction();
        transaction2.setTransactionId(102);
        transaction2.setTransactionType("Withdrawal");
        transaction2.setAmount(2000.00);
        transaction2.setBranchCode("BR002");
        transaction2.setBalance(8000.00);


        System.out.println("\nTransaction 2 Details:");
        System.out.println(transaction2);


        System.out.println("\nTesting Getters:");
        System.out.println("Transaction ID: " + transaction2.getTransactionId());
        System.out.println("Transaction Type: " + transaction2.getTransactionType());
        System.out.println("Transaction Amount: " + transaction2.getAmount());
        System.out.println("Branch Code: " + transaction2.getBranchCode());
        System.out.println("Balance: " + transaction2.getBalance());
    }
}