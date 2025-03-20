package com.bofa.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
    // Getter methods
    public int gettransactionId() {
        return transactionId;
    }
    public String gettransactionType() {
        return transactionType;
        
    }
    public String getbranchCode() {
        return branchCode;
        
    }
    public double getamount() {
        return amount;
    }
    public double getbalance() {
        return balance;
    }
    // Setter methods
    
    public int settransactionId() {
        return transactionId;
    }
    public String settransactionType() {
        return transactionType;
        
    }
    public String setbranchCode() {
        return branchCode;
        
    }
    public double setamount() {
        return amount;
    }
    public double setbalance() {
        return balance;
    }

  
    public void performOperations() {
        System.out.println("Initial balance: " + balance);
        
        //amount = 500;  
        System.out.println("Deposit amount: " + amount);
        balance = amount + balance;
        System.out.println("Balance after deposit: " + balance);

    }

 
   
}
