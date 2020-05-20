package com.example.demo.query.domain.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.example.demo.query.domain.entity.Query;
import com.example.demo.query.domain.repository.QueryRepository;

@Service("queryService")
public class QueryServiceImpl implements QueryService {

	private QueryRepository repository;
	
	@Autowired
	public QueryServiceImpl(QueryRepository repo) {
		this.repository = repo;
	}
	
	@Override
	public void add(Query query) throws Exception {
		repository.save(query);
		
	}

	@Override
	public void remove(Long id) throws Exception {
		repository.deleteById(id);
		
	}

	@Override
	public void update(Query query) throws Exception {
		repository.save(query);
	}

	@Override
	public Optional<Query> findById(Long id) throws Exception {
		return repository.findById(id);
		
	}

	@Override
	public List<Query> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Query> findByCategory(String category) {
		return repository.findByCategory(category);
	}

	
}
