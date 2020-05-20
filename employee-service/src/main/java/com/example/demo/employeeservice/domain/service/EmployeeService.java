package com.example.demo.employeeservice.domain.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.demo.employeeservice.domain.entity.Employee;

public interface EmployeeService {
	
	public Optional<Employee> findById (Long Id) throws Exception;
	
	public List<Employee> getAll();
	
	public List<Employee> findByGroup(String group);
}

