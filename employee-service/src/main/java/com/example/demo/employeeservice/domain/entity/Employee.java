package com.example.demo.employeeservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	Long id;
	@Column
	String name;
	@Column
	String EmpTitle;
	@Column
	String EmpGroup;
	
	public Employee() {
		
	}
	
	public Employee (String name, String title, String group) {	
		this.name = name;
		this.EmpTitle = title;
		this.EmpGroup = group;
	}


	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", name : ").append(name)
				.append(", title : ").append(EmpTitle)
				.append(", Group : ").append(EmpGroup)				
				.append(" }")
				.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpTitle() {
		return EmpTitle;
	}

	public void setEmpTitle(String empTitle) {
		EmpTitle = empTitle;
	}

	public String getEmpGroup() {
		return EmpGroup;
	}

	public void setEmpGroup(String empGroup) {
		EmpGroup = empGroup;
	}

	

}
