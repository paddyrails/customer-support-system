package com.example.demo.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.customer.domain.entity.Customer;
import com.example.demo.customer.domain.repository.CustomerRepository;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer cust = new Customer("John", "345 Glendale ct, Charlotte 28217", "HomeOwner", "Active");
		repository.save(cust);
		System.out.println("item created");
		
		Collection<Customer> customers = repository.findAll();
		customers.forEach(cust1 -> {
			System.out.println(cust1.toString());
		});
		
	}

}
