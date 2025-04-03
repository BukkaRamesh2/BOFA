package com.bofa.service;

import java.util.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bofa.model.Customer;
import com.bofa.repository.CustomerRepository;
import com.bofa.util.CompletableFututreExample;
import com.bofa.util.CustomerBalanceComparator;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	
	private List<Customer> customerCache = new ArrayList<>();
	
	private Set<Long> highBalanceCustomerIds = new HashSet<>();
	
	private Map<Long, Customer> customerMap = new HashMap<>();
	
	private final ExecutorService executorService =  Executors.newFixedThreadPool(5);   // new thread pool  size
	
	private final Lock customerLock = new ReentrantLock(); // object for lock 
	
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); //
	
	private final AtomicInteger atomicCoounter = new AtomicInteger(0);
			
	

	public synchronized Customer saveCustomer(Customer customer) {
		
		//use case synchroonised method for atomic writes 
		//Task 1  // error and kicedoff 
		//Task 2 
		System.out.println(Thread.currentThread().getName() + "is saving a customer: ");
		return custRepo.save(customer);
	}
	
	// save customer asycnhronously with @Async
	@Async
	@Transactional
	public CompletableFuture<Customer> saveCustomerAsycn(Customer customer) {
		
		return CompletableFuture.supplyAsync(() -> {
			customerLock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + " (ASYNC) saving a customer: ");
				return custRepo.save(customer);
			} finally {
				customerLock.unlock();

			}
		}, executorService);
		
	}
	
	

	@Override
	public Customer getCustomer(Long customerId) {
		// TODO Auto-generated method stub
		
		customerLock.lock();
		try {
		custRepo.findById(customerId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Custimer Not Found"));
		} finally {
			customerLock.unlock();
		}
		return custRepo.getById(customerId);
	}

	
	//Future and Callable
	@Override
	public List<Customer> getAllCustomers() {
		
		//use readwrite lock for better concurrency 
		List<Customer> custList = new ArrayList(); // I created a object of loist   
		
		readWriteLock.readLock().lock();
		try {
			custList = custRepo.findAll(); // get all customer from DB
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			readWriteLock.readLock().unlock();
		}
		
		
	
		
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

	// Async 
	//CompleteableFuture
	@Override
	public void deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		customerCache.add(null); // global variable 
		custRepo.deleteById(customerId);

	}

	@Override
	public Customer updateCustomer(Customer customer) throws Exception{
		// Save customer with control loop

		if (customer.getFirstName() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid first name");    // you can call the global exception class here 
			
		}
		
		
		customerCache.sort(new CustomerBalanceComparator());   /// it will compoare the object based on balance and sort the data 
		//customerCache.sort(new CustomerBalanceComparator().nameCompare(customer.getFirstName(), customer.getFirstName())); //
		
		Comparator<String> c = Comparator.comparing((String x) -> x);  // 

		switch (customer.getFirstName().toLowerCase()) {
		case "alex":
			System.out.println();
		case "sam":
			System.out.println();

		}

		return custRepo.save(customer);
	}

}
