package com.example.demo.kbservice.resources;

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

import com.example.demo.kbservice.domain.entity.KB;
import com.example.demo.kbservice.domain.service.KBService;
import com.example.demo.kbservice.domain.valueobject.KBVO;

@RestController
@RequestMapping("/v1/kb")
public class KBController {
	
	protected static final Logger logger = Logger.getLogger(KBController.class);
	
	protected KBService kbService;
	
	@Autowired
	public KBController(KBService kbSvc) {
		kbService = kbSvc;
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<KB>> findByCategory(@RequestParam("category") String category){
		logger.info(String.format("kb-service findByCategory invoked for {} for category '{}'", 
				KBController.class,
				category));
		List<KB> queries;
		if(category != null) {
			category = category.trim().toLowerCase();
		}
		try {
			if(category != null && "".equals(category)) {
				queries = kbService.getAll();
			}else {
				queries = kbService.findByCategory(category);
			}			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return queries != null ? new ResponseEntity<>(queries, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<KB>> findById(@PathVariable("id") String id){
		logger.info(String.format("kb-service findById invoked for {}: for id {}", 
				KBController.class, id));
		
		Optional<KB> kb;
		try {
			kb = kbService.findById(Long.parseLong(id));
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return kb != null ? new ResponseEntity<>(kb, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<KB> update(@RequestBody KBVO kbVO){
		logger.info(String.format("kb-service update invoked for {}: for id {}", 
				KBController.class, kbVO));
		
		Optional<KB> optional;
		try {
			optional = kbService.findById(kbVO.getId());
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		KB kb = optional.get();
		BeanUtils.copyProperties(kbVO, kb);
		try {
			kbService.update(kb);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);			
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<KB> add(@RequestBody KBVO kbVO){
		logger.info(String.format("kb-service add invoked for {}: for id {}", 
				KBController.class, kbVO.toString()));
		System.out.println(kbVO);
		KB kb = new KB(null, null, null, null, null);
		BeanUtils.copyProperties(kbVO, kb);
		try {
			kbService.add(kb);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return kb != null ? new ResponseEntity<>(HttpStatus.CREATED) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
