package com.example.demo.customer.domain.valueobject;

public class CustomerVO {
	Long id;
	String name;
	String Address;
	String ServiceType;
	String Status;
	
	public CustomerVO(String name, String address, String serviceType, String status) {
		this.name = name;
		this.Address = address;
		this.ServiceType = serviceType;
		this.Status = status;
	}

	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", name : ").append(name)
				.append(", address : ").append(Address)
				.append(", serviceType : ").append(ServiceType)
				.append(", status : ").append(Status)
				.append("}")
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
}
