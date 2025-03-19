package com.bofa.model;

public class Test2 {

	public Test2() {
		// TODO Auto-generated constructor stub
	}
	
	 public static void main(String[] args) {
	        Transaction t1 = new Transaction(101, "Deposit", 100.00, "BR001", 5000.0);
	        
	       
	        System.out.println("Transaction ID: " + t1.transactionId);
	        System.out.println("Type: " + t1.transactionType);
	        System.out.println("Branch: " + t1.branchCode);
	        
	      
	        t1.performOperations();
	    }


}
