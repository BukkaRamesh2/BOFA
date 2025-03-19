package com.bofa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.bofa.model.Transaction;

@SpringBootApplication
public class BofaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BofaApplication.class, args);
		
		Transaction t1 = new Transaction(101, "Deposit", 1000.0, "BR001");
		  
	//}
	
	
	
	
	/*
	 * 
	 *  Customer -- Raj
	 *    customerid
	 *    first name
	 *    last name
	 *    address
	 *    email
	 *    mobile number
	 *    gender
	 *  
	 *  Transaction -- Srijan 
	 *    transactionid
	 *    transactiontype
	 *    datetime
	 *    amount
	 *    branchCode
	 *  
	 *  Accounts  -- Alekhya
	 *    accountid
	 *    accountnumber
	 *    accounttype
	 *    balance   -- 
	 *    createdDate  -- date
	 *    status
	 *    
	 *  Employees -- Gowth
	 *   employeeid 
	 *   first name
	 *   last name
	 *   address
	 *   email 
	 *   mobile number
	 *   gender
	 *   pay/salary
	 *   
	 *  Branches  -- Laxman
	 *   branchid
	 *   branch name
	 *   branch address
	 *   branch manager
	 *   branch code
	 *   Timings
	 *  
	 *  Services   -- Rupesh
	 *   ServiceId
	 *   Lending Services -- auto , personal,
	 *   Retail Services --
	 *   Digital Services  -- 
	 *   Customer Service -- 
	 *   
	 *  
	 *  Model // POJO
	 *    
	 *  object ]
	 *  attributes
	 *  data types
	 *  access specifiers 
	 *  constructor
	 *  
	 *  
	 *  
	 *  
	 *  
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	}}
