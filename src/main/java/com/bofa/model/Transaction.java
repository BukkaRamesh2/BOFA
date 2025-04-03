package com.bofa.model;

import com.bofa.exception.ExceptionHandling;

public class Transaction {
    private int transactionId;
    private String transactionType;
    private double amount;
    private String branchCode;
    private double balance;

    // Constructor
    public Transaction() {}

    public Transaction(int transactionId, String transactionType, double amount, String branchCode, double balance) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.branchCode = branchCode;
        this.balance = balance;
    }

    // Getters and Setters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

   // conditional stmts and switch case
    public void processTransaction() throws ExceptionHandling {
        if (transactionType == null || transactionType.trim().isEmpty()) {
            throw new ExceptionHandling("Transaction type cannot be empty");
        }
        if (branchCode == null || branchCode.trim().isEmpty()) {
            throw new ExceptionHandling("Branch code cannot be empty");
        }
        if (amount <= 0) {
            throw new ExceptionHandling("Amount must be greater than zero");
        }

        switch (transactionType.toUpperCase()) {
            case "DEPOSIT":
                balance += amount;
                break;
            case "WITHDRAWAL":
                if (amount > balance) {
                    throw new ExceptionHandling("Insufficient funds");
                }
                balance -= amount;
                break;
            default:
                throw new ExceptionHandling("Invalid transaction type");
        }
        System.out.println("Transaction successful: " + this);
    }

    @Override
    public String toString() {
        return String.format("Transaction{id=%d, type='%s', amount=%.2f, branch='%s', balance=%.2f}", 
                             transactionId, transactionType, amount, branchCode, balance);
    }

    // Main method
    public static void main(String[] args) {
        try {
            Transaction deposit = new Transaction(1, "DEPOSIT", 500.0, "BR001", 1000.0);
            deposit.processTransaction();

            Transaction withdrawal = new Transaction(2, "WITHDRAWAL", 2000.0, "BR002", 1000.0);
            withdrawal.processTransaction();
        } catch (ExceptionHandling e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}