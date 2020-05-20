package com.example.demo.employeeservice.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.employeeservice.domain.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
//	boolean containsName(String name);
//	public Collection<Employee> findByName(String name) throws Exception;
	@Query("SELECT q FROM Employee q WHERE LOWER(q.EmpGroup) = LOWER(:group)")
    public List<Employee> findByGroup(String group);
	
	
	
}
