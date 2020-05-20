package com.example.demo.customer.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.domain.entity.Customer;
import com.example.demo.customer.domain.repository.CustomerRepository;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Optional<Customer> findById(Long id) throws Exception {
		return repository.findById(id);		
	}

	@Override
	public List<Customer> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Customer> containsName(String name) {
		
		return repository.containsName(name);
	}
}

