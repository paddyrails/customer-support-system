package com.example.demo.query.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.query.domain.entity.Query;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface QueryRepository extends JpaRepository<Query, Long>{
	
//	boolean containsName(String name);
//	public Collection<Query> findByName(String name) throws Exception;
	@org.springframework.data.jpa.repository.Query("SELECT q FROM Query q WHERE LOWER(q.Category) = LOWER(:category)")
    public List<Query> findByCategory(String category);
	
	
}
