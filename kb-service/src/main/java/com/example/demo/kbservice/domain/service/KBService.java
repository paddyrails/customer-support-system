package com.example.demo.kbservice.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.kbservice.domain.entity.KB;

public interface KBService {

	public void add(KB kb) throws Exception;
	
	public void remove(Long id) throws Exception;
	
	public void update (KB kb) throws Exception;
	
	public Optional<KB> findById (Long Id) throws Exception;
	
	public List<KB> getAll();
	
	public List<KB> findByCategory(String category);
	
	public List<KB> containsName(String name);
}
