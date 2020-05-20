package com.example.demo.collaboration.resources;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.collaboration.domain.entity.Post;
import com.example.demo.collaboration.domain.service.CollaborationService;
import com.example.demo.collaboration.domain.valueobject.PostVO;

@RestController
@RequestMapping("/v1/post")
public class CollaborationController {
	
	protected static final Logger logger = Logger.getLogger(CollaborationController.class);
	
	protected CollaborationService postService;
	
	@Autowired
	public CollaborationController(CollaborationService postSvc) {
		postService = postSvc;
	}	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Post>> containsName(@RequestParam("text") String text){
		logger.info(String.format("colaboration-service containsNAme invoked for {} for category '{}'", 
				CollaborationController.class,
				text));
		List<Post> posts;
		if(text != null) {
			text = text.trim().toLowerCase();
		}
		if(text != null) {
			text = text.trim().toLowerCase();
		}
		try {
			if(text != null && "".equals(text)) {
				posts = postService.getAll();
			}else {
				System.out.println("in contains text : " + text);
				posts = postService.containsText(text);
			}			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return posts != null ? new ResponseEntity<>(posts, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Collection<Post>> findByCategory(@RequestParam("category") String category){
//		logger.info(String.format("post-service findByCategory invoked for {} for category '{}'", 
//				CollaborationController.class,
//				category));
//		List<Post> posts;
//		if(category != null) {
//			category = category.trim().toLowerCase();
//		}
//		try {
//			if(category != null && "".equals(category)) {
//				posts = postService.getAll();
//			}else {
//				posts = postService.findByCategory(category);
//			}			
//		}catch(Exception ex) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return posts != null ? new ResponseEntity<>(posts, HttpStatus.OK) :
//			new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Post>> findById(@PathVariable("id") String id){
		logger.info(String.format("collaboration-service findById invoked for {}: for id {}", 
				CollaborationController.class, id));
		
		Optional<Post> post;
		try {
			post = postService.findById(Long.parseLong(id));
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return post != null ? new ResponseEntity<>(post, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Post> update(@RequestBody PostVO postVO){
		logger.info(String.format("post-service update invoked for {}: for id {}", 
				CollaborationController.class, postVO));
		
		Post post = new Post(null, null, null);
		BeanUtils.copyProperties(postVO, post);
		try {
			postService.update(post);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);			
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Post> add(@RequestBody PostVO postVO){
		logger.info(String.format("post-service add invoked for {}: for id {}", 
				CollaborationController.class, postVO.toString()));
		System.out.println(postVO);
		Post post = new Post(null, null, null);
		BeanUtils.copyProperties(postVO, post);
		try {
			postService.add(post);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return post != null ? new ResponseEntity<>(HttpStatus.CREATED) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
