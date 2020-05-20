package com.example.demo.collaboration.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.collaboration.domain.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CollaborationRepository extends JpaRepository<Post, Long>{
	
//	boolean containsName(String name);
//	public Collection<Query> findByName(String name) throws Exception;
	@org.springframework.data.jpa.repository.Query("SELECT p FROM Post p WHERE p.CreatedBy = :createdBy")
    public List<Post> findByCreatedBy(Long createdBy);
	
	@org.springframework.data.jpa.repository.Query("SELECT p FROM Post p WHERE LOWER(p.Content) LIKE %:text%")
    public List<Post> containsText(String text);
}
