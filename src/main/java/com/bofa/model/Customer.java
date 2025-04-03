/**
 * 
 */
package com.bofa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ramesh b
 */

@Entity
@Data
@Table(name = "tb_customer")
public class Customer implements Comparable<Customer>{

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
	 * jdlkadf
	 * Integer -- 1 -- 10mb Long -- 123144 -- 100mb Boolean -- true /false -- String
	 * -- combinatiopn of characters and words Char -- single char Double -- 2.34234
	 * Float -- 2.3
	 * 
	 * 
	 * naming convenstions to create class, varibales,
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
	 *     
	 *     //Controller
	 *     
	 *     @RestController
	 *     @RequestMapping 
	 *     
	 *     @Autowired
	 *     
	 *     
	 *     @Get
	 *     @Post
	 *     
	 *     
	 *     
	 *     send data to service 
	 *     
	 *     Service -- 
	 *     @Service
	 *     
	 *     
	 *     
	 *     Interface  -- abstract methods 
	 *     Class -- keywoprd   implements 
	 *     
	 *     
	 *     Reporsitory
	 *      @Repository
	 *      
	 *      
	 *      Interface extending the JPA<Customer, Long>
	 *      
	 *     
	 *     model
	 *     @Entity
	 *     @Getter
	 *     @Seeter
	 *     @Data
	 *     @NoArgsContructor
	 *     @AllArgsContrsuctor
	 *     
	 *     @Id
	 *     
	 *     
	 *     
	 *     
	 *     H2 in built database for your spring boot applicaiotns
	 *     
	 *     {
	 *     "firstName":",
	 *     "lastName":",
	 *     "address":",
	 *     "email":",
	 *     "mobileNumber":"
	 *     }
	 *     
	 *    http
	 * 
	 * 
	 *  Collections
	 *     
	 *     List, set, map  -- interface
	 *     
	 *     LinkedList    -- you can access the daata by their [postoions [5] = {"",}
	 *     ArrayList
	 *     
	 *     List<E> list = new ArrayList<>();       [0], [1], [2], 
	 *     List<E> linkedList = new LinkedList<>();    [0, data, 1]
	 *     
	 *     Array list 
	 *     insertion time is faster 
	 *     
	 *     
	 *     
	 *     
	 *     Set will not allow duplicates
	 *     
	 *     add()
	 *     clear()
	 *     isEmpty()
	 *     size()
	 *     remove()
	 *     contains()
	 *     
	 *     LinkedHashSet
	 *     TreeeSet    -- natural sorting order 
	 *     HashSet   -- insertion order 
	 *     
	 *     HashMap
	 *     LinkeHashMap    --- key value pair 
	 *     TreeMap
	 *     
	 *     
	 *     Comparable 
	 *     natureal sorting 
	 *     compareTo()
	 *     model class 
	 *     single sorting /// you can sort one variable/ filed in a class
	 *     
	 *     
	 *     
	 *     comparator
	 *     custom sorting logic
	 *     compare()
	 *     the mplelemtation should happen in separaet class
	 *     you can sort multiple variables / fiedls
	 *     
	 *     
	 *     
	 *       Expcetion 
	 *       
	 *       
	 *       Run time    
	 *       Compile time 
	 *       
	 *       try{
	 *          // main logic 
	 *          multipe operations
	 *          
	 *       } catch(Exception e){
	 *       e.printStackTracke();
	 *       throws new classname of exception
	 *       } catch(NullPointerEXception e){
	 *       
	 *       }
	 *       
	 *       try(open operations){
	 *       
	 *       } // try with resousce 
	 *       
	 *       
	 *       throws 
	 *       if you have any class level exception you can use throw and this will be part of your method
	 *       
	 *       
	 *       throw
	 *       this will be part of your catch block
	 *       you are going to threow new excetion and passa a method name or class name 
	 *       
	 *       finally
	 *       this is executed if any exceton occurs or not the finally block will be executed with out faioure 
	 *       if i want to close DB coneeectiikn  or file ooperations 
	 *       closing the file ofter alter / updating the inforamtion oin FILEINputStram and FIleOutputStram
	 *       
	 *       Global exceptpjins
	 *       
	 *       @RestControllerAdvice   // Exception  class level
	 *       
	 *       @ExceptionHandler   // use this on top of methods 
	 *       
	 *       
	 *       
	 * 
	 */
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public Long customerId;

	@Column(nullable = false)
	private String firstName;

	private String lastName;   // this scope is only inside this class you can't access this variable outside the class
	
	protected String address;  // scope of inside package 
	
	private String email;
	
	private Long mobileNumber;
	
	private String gender;
	
	private boolean status;
	
	private Long balance;
	
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Customer.name = name;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
