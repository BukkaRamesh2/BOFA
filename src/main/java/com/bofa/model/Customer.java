/**
 * 
 */
package com.bofa.model;

/**
 * ramesh b
 */
public class Customer {

	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Data types
	 * jdlkadf
	 * Integer -- 1 -- 10mb Long -- 123144 -- 100mb Boolean -- true /false -- String
	 * -- combinatiopn of characters and words Char -- single char Double -- 2.34234
	 * Float -- 2.3
	 * 
	 * 
	 * naming copnvenstions to create class, varibales,
	 * 
	 * Syntax : access specifier datatype name
	 * 
	 *   access specifieers
	 *   
	 *   public -- it can be accessible by any one in the aopplication and anywhere in the application
	 *   
	 *   private   --- the scope will be only inside the class
	 *   protected
	 *   default   --
	 *   
	 * 
	 * 
	 */

	public long customerId;

	public String firstName;

	private String lastName;   // this scope is only inside this class you can't access this variable outside the class
	
	protected String address;  // scope of inside package 
	
	private String email;
	
	private Long mobileNumber;
	
	private String gender;
	
	private boolean status;

}
