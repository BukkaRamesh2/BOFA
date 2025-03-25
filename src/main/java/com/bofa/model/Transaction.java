package com.bofa.model;

public class Transaction {
    public int transactionId;
    public String transactionType;
    public double amount;
    public String branchCode;
    public double balance;

    // Manually defined constructor
    public Transaction(int transactionId, String transactionType, double amount, String branchCode, double balance) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.branchCode = branchCode;
        this.balance = balance;
    }

    // Manually defined no-args constructor (optional)
    public Transaction() {
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void performOperations() {
        System.out.println("Initial balance: " + balance);
        System.out.println("Deposit amount: " + amount);
        balance = amount + balance;
        System.out.println("Balance after deposit: " + balance);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", branchCode='" + branchCode + '\'' +
                ", balance=" + balance +
                '}';
    }
}