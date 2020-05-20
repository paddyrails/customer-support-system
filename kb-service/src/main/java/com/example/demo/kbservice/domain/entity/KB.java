package com.example.demo.kbservice.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class KB {
	
	@Id
	@GeneratedValue
	Long id;
	String name;
	@Column
	String Category;
	@Lob
	@Column(length=1024)
	String Description;
	@Column
	LocalDateTime CreatedAt;
	@Column
	String CreatedBy;
	@Column
	Long Parent;
	
	public KB() {
		
	}
	
	public KB (String name, String category, String description, String createdBy, Long parent) {	
		this.Category = category;
		this.Description = description;
		this.CreatedAt = LocalDateTime.now();
		this.CreatedBy = createdBy;
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
