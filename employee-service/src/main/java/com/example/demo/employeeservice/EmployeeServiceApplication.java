package com.example.demo.employeeservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.employeeservice.domain.entity.Employee;
import com.example.demo.employeeservice.domain.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeServiceApplication implements CommandLineRunner{

	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee("Agnes", "Customer Support Associate", "Customer-Support");
		employeeRepository.save(emp);
		System.out.println("Item created");
		Collection<Employee> employees = employeeRepository.findAll();
		employees.forEach(emp1 -> {
			System.out.println(emp1.toString());
		});
	}

}



