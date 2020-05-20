package com.example.demo.query.domain.valueobject;

import java.time.LocalDateTime;

public class QueryVO {
	Long id;
	String name;
	String Category;
	String Description;
	String CustomerId;
	LocalDateTime CreatedAt;
	String Status;
	String AssignedTo;
	String Resolution;
	LocalDateTime ClosedAt;
	
	public QueryVO(String name, String category, String description, String custId) {
		this.name = name;
		this.Category = category;
		this.Description = description;
		this.CustomerId = custId;
	}

	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", name : ").append(name)
				.append(", Category : ").append(Category)
				.append(", Description : ").append(Description)
				.append(", CustomerId : ").append(CustomerId)
				.append(", CreatedAt : ").append(CreatedAt)
				.append(", Status : ").append(Status)
				.append(", AssignedTo : ").append(AssignedTo)
				.append(", Resolution : ").append(Resolution)
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

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
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

	public String getAssignedTo() {
		return AssignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		AssignedTo = assignedTo;
	}

	public String getResolution() {
		return Resolution;
	}

	public void setResolution(String resolution) {
		Resolution = resolution;
	}

	public LocalDateTime getClosedAt() {
		return ClosedAt;
	}

	public void setClosedAt(LocalDateTime closedAt) {
		ClosedAt = closedAt;
	}
	
	
}
