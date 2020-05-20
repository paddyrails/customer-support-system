package com.example.demo.collaboration.domain.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.collaboration.domain.entity.Post;
import com.example.demo.collaboration.domain.repository.CollaborationRepository;

@Service("collaborationService")
public class CollaborationServiceImpl implements CollaborationService {

	private CollaborationRepository repository;
	
	@Autowired
	public CollaborationServiceImpl(CollaborationRepository repo) {
		this.repository = repo;
	}

	@Override
	public void add(Post post) throws Exception {
		repository.save(post);		
	}

	@Override
	public void remove(Long id) throws Exception {
		repository.deleteById(id);
		
	}

	@Override
	public void update(Post post) throws Exception {
		repository.save(post);
		
	}

	@Override
	public Optional<Post> findById(Long Id) throws Exception {
		
		return repository.findById(Id);
	}

	@Override
	public List<Post> getAll() {
		
		return repository.findAll();
	}

	@Override
	public List<Post> containsText(String text) {

		return repository.containsText(text);
	}
	
	}
