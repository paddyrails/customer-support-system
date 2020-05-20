package com.example.demo.customer.resources;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.customer.domain.entity.Customer;
import com.example.demo.customer.domain.service.CustomerService;


@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
	
	protected static final Logger logger = Logger.getLogger(CustomerController.class);
	
	protected CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService qSvc) {
		customerService = qSvc;
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Customer>> findByName(@RequestParam("name") String name){
		logger.info(String.format("customer-service findByName invoked for {} for name '{}'", 
				CustomerController.class,
				name));
		List<Customer> customers;
		if(name != null) {
			name = name.trim().toLowerCase();
		}
		try {
			if(name != null && "".equals(name)) {
				customers = customerService.getAll();
			}else {
				customers = customerService.containsName(name);
			}			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return customers != null ? new ResponseEntity<>(customers, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Customer>> findById(@PathVariable("id") String id){
		logger.info(String.format("customer-service findById invoked for {}: for id {}", 
				CustomerController.class, id));
		
		Optional<Customer> customer;
		try {
			customer = customerService.findById(Long.parseLong(id));
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
