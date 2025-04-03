package com.bofa.util;

import java.util.Comparator;

import com.bofa.model.Customer;

public class CustomerBalanceComparator implements Comparator<Customer> {

	public CustomerBalanceComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return Long.compare(o1.getBalance(), o2.getBalance());
	}
	
	
	public int nameCompare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
}
