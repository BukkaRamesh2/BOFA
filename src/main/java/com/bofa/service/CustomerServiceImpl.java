package com.bofa.service;

import java.util.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bofa.model.Customer;
import com.bofa.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	
	private List<Customer> customerCache = new ArrayList<>();
	
	private Set<Long> highBalanceCustomerIds = new HashSet<>();
	
	private Map<Long, Customer> customerMap = new HashMap<>();
	
	

	public Customer saveCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	@Override
	public Customer getCustomer(Long customerId) {
		// TODO Auto-generated method stub
		custRepo.findById(customerId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Custimer Not Found"));
		return custRepo.getById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> custList = new ArrayList(); // I created a object of loist

		custList = custRepo.findAll(); // get all customer from DB
		
		if (custList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No customer found");
		}

		Iterator<Customer> iterator = custList.iterator();
		while(iterator.hasNext()) {
			Customer cust = iterator.next();
			if(cust.getBalance() < 500) {
				iterator.remove();
			}
		}
		
		Set<Customer> uniqueData = new TreeSet<>(custList);  // pass your list to set object and print set that will have uniquw elements 
		
		
		
		customerCache.addAll(custList);
		
		// using map get all customer IDs greater than 1000
		
		for(Customer customer: custList) {
			customerMap.put(customer.getCustomerId(), customer);
			if(customer.getBalance() > 1000) {
				highBalanceCustomerIds.add(customer.getCustomerId());  // key value pair data 
			}
		}
		
		// get customer by ID with Map lookup
		
		
		
		// using for each loop to process customer

		custList.forEach(customer -> {

			custRepo.findByFirstName(customer.getFirstName()); ///

			if (customer.getFirstName().equals("Alex")) {
				System.out.println(" The Alex is exisiting in database");
			}
		});

		return custList;
	}

	@Override
	public void deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub

		custRepo.deleteById(customerId);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// Save customer with control loop

		if (customer.getFirstName() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid first name");
		}

		switch (customer.getFirstName().toLowerCase()) {
		case "alex":
			System.out.println();
		case "sam":
			System.out.println();

		}

		return custRepo.save(customer);
	}

}
