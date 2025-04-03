package com.bofa.model;

public class Services {
	
	public long serviceId;
	
	protected boolean status;
	
	private String customerService;
	
	public String[] retailServices;
	
	public String[] digitalServices;
	
	public String[]	lendingServices;
	
	//Parameterized constructor
	public Services(long serviceId, boolean status, String customerService,
			String[] retailServices, String[] digitalServices, String[] lendingServices)
	{
		this.serviceId = serviceId;
		this.status = status;
		this.setCustomerService(customerService);
		this.retailServices = retailServices;
		this.digitalServices = digitalServices;
		this.lendingServices = lendingServices;
		
		System.out.println("Fully paramterised constructor is called");
	}
	
	//Default Constructor
	public Services()
	{
		System.out.println("The default constructor is called");
	}
	
	
	//Getter and setter methods
	
	public long getServiceId()
	{
		return serviceId;
	}
	
	public void setServiceId(long serviceId)
	{
		this.serviceId=serviceId;
	}
	
	
	public boolean isStatus() 
	{
		return status;
	}

	public void setStatus(boolean status) 
	{
		this.status = status;
	}
	

	public String getCustomerService() 
	{
		return customerService;
	}


	public void setCustomerService(String customerService) 
	{
		this.customerService = customerService;
	}
	
	
	public String[] getRetailService()
	{
		return retailServices;
	}

	public void setRetailService(String[] retailServices)
	{
		this.retailServices = retailServices;
	}
	
	public String[] getDigitalServices() 
	{
		return digitalServices;
	}

	public void setDigitalServices(String[] digitalServices)
	{
		this.digitalServices = digitalServices;
	}

	public String[] getLendingServices() 
	{
		return lendingServices;
	}

	public void setLendingServices(String[] lendingServices) 
	{
		this.lendingServices = lendingServices;
	}
	
	//Addition Method
	public static int add(int a, int b)
	{
		a = 20;
		b = 24;
		
		int c = a+b;
			
		System.out.println(c);
		
		return c;
	}
	
	
}

/*
*  Services   -- Vishnu
*   ServiceId  == long
*   Lending Services -- auto , personal, list
*   Retail Services --  list
*   Digital Services  --  list
*   Customer Service -- string
*   Status -- boolean

*/