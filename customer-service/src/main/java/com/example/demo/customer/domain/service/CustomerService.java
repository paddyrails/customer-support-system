package com.example.demo.customer.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.customer.domain.entity.Customer;

public interface CustomerService {

	public Optional<Customer> findById (Long Id) throws Exception;
	
	public List<Customer> getAll();
	
	public List<Customer> containsName(String name);
}
