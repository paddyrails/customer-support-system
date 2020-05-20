package com.example.demo.collaboration.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	Long id;
	@Lob
	@Column(length=1024)
	String Content;
	LocalDateTime CreatedAt;
	@Column
	String CreatedBy;
	@Column
	String Parent;
//	@Column
//	Long[] likes;
	
	public Post() {
		
	}
	
	public Post (String content, String createdBy, String parent) {	
		this.Content=content;
		this.CreatedAt = LocalDateTime.now();
		this.CreatedBy = createdBy;
		this.Parent = parent;
	}


	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", content : ").append(Content)
				.append(", createdAt : ").append(CreatedAt)
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

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
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

	public String getParent() {
		return Parent;
	}

	public void setParent(String parent) {
		Parent = parent;
	}
		
}
