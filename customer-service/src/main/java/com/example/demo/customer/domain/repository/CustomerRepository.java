package com.example.demo.customer.domain.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.customer.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@org.springframework.data.jpa.repository.Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE %:name%")
    public List<Customer> containsName(String name);
	
	
}
