package com.bofa.model;

public class Transaction {
	public int transactionId;
    public String transactionType;
    public double amount;
    public String branchCode;
    public double balance;

    // Constructor Initialization
    public Transaction(int transactionId, String transactionType, double amount, String branchCode, double balance) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.branchCode = branchCode;
        this.balance = balance;
    }

  
    public void performOperations() {
        System.out.println("Initial balance: " + balance);
        
        //amount = 500;  
        System.out.println(" transaction amount: " + amount);
        balance = amount + balance;
        System.out.println("Balance after deposit: " + balance);

    }

 
   
}
