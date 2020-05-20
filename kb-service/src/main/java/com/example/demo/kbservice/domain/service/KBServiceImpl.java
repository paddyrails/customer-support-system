package com.example.demo.kbservice.domain.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.example.demo.kbservice.domain.entity.KB;
import com.example.demo.kbservice.domain.repository.KBRepository;

@Service("kbService")
public class KBServiceImpl implements KBService {

	private KBRepository repository;
	
	@Autowired
	public KBServiceImpl(KBRepository repo) {
		this.repository = repo;
	}
	
	@Override
	public void add(KB kb) throws Exception {
		repository.save(kb);
		
	}

	@Override
	public void remove(Long id) throws Exception {
		repository.deleteById(id);
		
	}

	@Override
	public void update(KB kb) throws Exception {
		repository.save(kb);
	}

	@Override
	public Optional<KB> findById(Long id) throws Exception {
		return repository.findById(id);
		
	}

	@Override
	public List<KB> getAll() {
		return repository.findAll();
	}

	@Override
	public List<KB> findByCategory(String category) {
		return repository.findByCategory(category);
	}

	@Override
	public List<KB> containsName(String name) {
		return repository.containsName(name);
	}

	
}
