package com.example.demo.employeeservice.resources;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeservice.domain.entity.Employee;
import com.example.demo.employeeservice.domain.service.EmployeeService;
import com.example.demo.employeeservice.domain.valueobject.EmployeeVO;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
	
	protected static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	protected EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService qSvc) {
		employeeService = qSvc;
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Employee>> findByCategory(@RequestParam("group") String group){
		logger.info(String.format("employee-service findByCategory invoked for {} for category '{}'", 
				EmployeeController.class,
				group));
		List<Employee> queries;
		if(group != null) {
			group = group.trim().toLowerCase();
		}
		try {
			if(group != null && "".equals(group)) {
				queries = employeeService.getAll();
			}else {
				queries = employeeService.findByGroup(group);
			}			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return queries != null ? new ResponseEntity<>(queries, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Employee>> findById(@PathVariable("id") String id){
		logger.info(String.format("employee-service findById invoked for {}: for id {}", 
				EmployeeController.class, id));
		
		Optional<Employee> employee;
		try {
			employee = employeeService.findById(Long.parseLong(id));
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return employee != null ? new ResponseEntity<>(employee, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
