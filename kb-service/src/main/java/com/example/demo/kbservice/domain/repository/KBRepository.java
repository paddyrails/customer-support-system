package com.example.demo.kbservice.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.kbservice.domain.entity.KB;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface KBRepository extends JpaRepository<KB, Long>{
	
//	boolean containsName(String name);
//	public Collection<Query> findByName(String name) throws Exception;
	@org.springframework.data.jpa.repository.Query("SELECT k FROM KB k WHERE LOWER(k.Category) = LOWER(:category)")
    public List<KB> findByCategory(String category);
	
	@org.springframework.data.jpa.repository.Query("SELECT k FROM KB k WHERE LOWER(k.name) LIKE %:name%")
    public List<KB> containsName(String name);
}
