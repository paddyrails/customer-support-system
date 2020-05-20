package com.example.demo.kbservice.domain.valueobject;
import java.time.LocalDateTime;

public class KBVO {
	Long id;
	String name;
	String Category;
	String Description;
	LocalDateTime CreatedAt;
	String CreatedBy;
	Long Parent;
	
	public KBVO(String name, String category, String description,String createdBy, Long parent) {
		this.name = name;
		this.Category = category;
		this.Description = description;
		this.CreatedBy =  createdBy;
		this.Parent = parent;
	}

	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", name : ").append(name)
				.append(", Category : ").append(Category)
				.append(", Description : ").append(Description)
				.append(", CreatedAt : ").append(CreatedAt)
				.append(", CreatedBy : ").append(CreatedBy)
				.append(", Parent : ").append(Parent)
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

	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		CreatedAt = createdAt;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public Long getParent() {
		return Parent;
	}

	public void setParent(Long parent) {
		Parent = parent;
	}

	
	
	
}
