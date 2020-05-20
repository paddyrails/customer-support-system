package com.example.demo.query.domain.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.demo.query.domain.entity.Query;

public interface QueryService {

	public void add(Query query) throws Exception;
	
	public void remove(Long id) throws Exception;
	
	public void update (Query query) throws Exception;
	
	public Optional<Query> findById (Long Id) throws Exception;
	
	public List<Query> getAll();
	
	public List<Query> findByCategory(String category);
}
