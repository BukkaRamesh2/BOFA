package com.bofa.model;

public class Test2 {

	public Test2() {
		// TODO Auto-generated constructor stub
	}
	
	 public static void main(String[] args) {
		 Transaction transaction = new Transaction(1, "Deposit", 500.0, "BR001", 1000.0);
	        
	       
	
	        transaction.performOperations();
	        
	      
	        System.out.println(transaction);
	    }


}
