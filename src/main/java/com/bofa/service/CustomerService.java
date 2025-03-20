package com.bofa.service;

import java.util.List;

import com.bofa.model.Customer;

public interface CustomerService {
	
	// I have to perform 4 operations for customer add delete get update
	
	/*
	 * 
	 * 
	 *  
	 */
	
	
	public Customer getCustomer(Long customerId);
	
	public List<Customer> getAllCustomers();
	
	public void deleteCustomer(Long customerId);
	
	public Customer updateCustomer(Customer customer);
	
	

}
