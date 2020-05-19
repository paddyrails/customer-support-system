package com.example.demo.query.domain.entity;

public abstract class CEntity<T> {
	T id;
	String name;
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
