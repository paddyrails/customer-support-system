package com.example.demo.employeeservice.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employeeservice.domain.entity.Employee;
import com.example.demo.employeeservice.domain.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Optional<Employee> findById(Long id) throws Exception {
		return repository.findById(id);		
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Employee> findByGroup(String group) {
		return repository.findByGroup(group);
	}
}
