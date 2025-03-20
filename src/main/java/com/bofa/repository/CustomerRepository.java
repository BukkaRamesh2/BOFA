package com.bofa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bofa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
