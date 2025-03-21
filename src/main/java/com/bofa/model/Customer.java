/**
 * 
 */
package com.bofa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ramesh b
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	/**
	 * 
	 */
	public Customer() {
		System.out.println("the default const is called");
	}
	
	public Customer(long customerId) {
		this.customerId = customerId;
		System.out.println("the customerid const is called");
	}
	
	public Customer(String firstName) {
		
	}
	
	
	/*
	 *  Constructor will have same class name
	 *  you can have default const
	 *  and parametrized construct
	 *  you can have n no of constr
	 *  
	 *  
	 *  the constructors are useful while you create an object 
	 * 
	 * 
	 * Data types
	 * 
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
	 *   Varaibles 
	 *   
	 *   local 
	 *   global
	 *   
	 *   
	 *   method 
	 *   
	 *   syntax: 
	 *   accessspecifier returntype methodname(parameters/method signiture){
	 *   method body
	 *   }
	 *   
	 *   the retyurn types can be data types or objects, entities 
	 *   void -- will not expect anything 
	 *   
	 *   
	 *   // operators 
	 *   arithmetic operatiors   // +, -, *, /, %, ++, --
	 *   assignment    //   = , += , 
	 *   relational    // == , !=, >, <, <=, >= 
	 *   logic operators  && , ||
	 *   
	 *     bitwise 1 = 0001
	 *     int a = ++1
	 *     
	 *     c += a 
	 *     c = c + a //  both 
	 *     
	 *     
	 *     Control statments 
	 *     
	 *     if () 
	 *     {
	 *       if(){
	 *          /// 
	 *       }
	 *     }
	 *     else if(condition){
	 *     
	 *     }
	 *     
	 *     switch ()
	 *     
	 *     cases 1: 
	 *     
	 *   list of 5 customer  
	 *     for ()
	 *     
	 *     while(Boolean_Expression){
	 *        
	 *        break;
	 *        
	 *        continue;
	 *        
	 *        
	 *     }
	 *     
	 *     do {
	 *     
	 *      }
	 *      while();
	 *      
	 *     
	 * 
	 * 
	 */

	public Long customerId;

	private String firstName;

	private String lastName;   // this scope is only inside this class you can't access this variable outside the class
	
	protected String address;  // scope of inside package 
	
	private String email;
	
	private Long mobileNumber;
	
	private String gender;
	
	private boolean status;
	
	static String name = "Alex";  // variable the scope of this varaible is there till entire class because you made it as globa; variable 
	
	
	
	public static int calc(int a, int b ) {
	  a = 1;
	  b = 2;
	  
	  int c = a+b;    // variable  the scope of varaibale c is exists only insied calac method
	  
	  
	  
	  System.out.println(c);
		
		return c;
	}
	
	public static void main(String[] args) {
		
		
		int a=0, b=0, x=1;
		
		calc(a,b);   // output
		
		  System.out.println(name);
		
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;  
	}
	
	
	

}
