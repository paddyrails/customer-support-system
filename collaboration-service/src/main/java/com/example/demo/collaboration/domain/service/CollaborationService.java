package com.example.demo.collaboration.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.collaboration.domain.entity.Post;

public interface CollaborationService {

	public void add(Post post) throws Exception;
	
	public void remove(Long id) throws Exception;
	
	public void update (Post post) throws Exception;
	
	public Optional<Post> findById (Long Id) throws Exception;
	
	public List<Post> getAll();
	
	public List<Post> containsText(String text);
}
