package com.example.demo.collaboration.domain.valueobject;

import java.time.LocalDateTime;

public class PostVO {
	Long id;
	String Content;
	LocalDateTime CreatedAt;
	String CreatedBy;
	String Parent;
	
	public PostVO(String content, String createdBy, String parent) {
		this.Content = content;
		this.CreatedBy =  createdBy;
		this.CreatedAt =  LocalDateTime.now();
		this.Parent = parent;
	}

	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", content : ").append(Content)
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
