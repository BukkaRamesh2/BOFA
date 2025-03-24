package com.bofa.model;
import java.time.LocalDateTime;

public class Accounts {

	public long accountId;
	public long accountNumber;
	public String accountType;
	private long balance;
	public LocalDateTime createdDate;
	public boolean status;
	
	public Accounts(long accountId, long accountNumber, String accountType, long balance, boolean status) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.createdDate = LocalDateTime.now();
        this.status = status;
    }


public void main(String[] args) {
   //Accounts account1 = new Accounts(001, 987654321, "Savings", 5000, true);
   //Accounts account2 = new Accounts(002, 123456789, "Checking", 3000, true);
	accountId = 001;
	accountNumber = 123456789;
	accountType = "savings";
	balance = 10000;
	status = true;
}
}