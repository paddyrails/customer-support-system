package com.example.demo.customer.domain.entity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	Long id;
	@Column
	String name;
	@Column
	String Address;
	@Column
	String ServiceType;
	@Column
	LocalDateTime CreatedAt;
	@Column
	String Status;
	@Column
	LocalDateTime ClosedAt;
	
	public Customer() {
		
	}
	
	public Customer (String name, String address, String serviceType, String status) {	
		this.name=name;
		this.Address = address;
		this.ServiceType = serviceType;
		this.Status = status;
		this.CreatedAt = LocalDateTime.now();
	}


	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", name : ").append(name)
				.append(", Address : ").append(Address)
				.append(", ServiceType : ").append(ServiceType)
				.append(", Status : ").append(Status)
				.append(", CreatedAt : ").append(CreatedAt)
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}

	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		CreatedAt = createdAt;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public LocalDateTime getClosedAt() {
		return ClosedAt;
	}

	public void setClosedAt(LocalDateTime closedAt) {
		ClosedAt = closedAt;
	}

	
}
