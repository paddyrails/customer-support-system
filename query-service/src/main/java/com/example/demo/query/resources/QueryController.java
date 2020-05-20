package com.example.demo.query.resources;

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

import com.example.demo.query.domain.entity.Query;
import com.example.demo.query.domain.service.QueryService;
import com.example.demo.query.domain.valueobject.QueryVO;

@RestController
@RequestMapping("/v1/query")
public class QueryController {
	
	protected static final Logger logger = Logger.getLogger(QueryController.class);
	
	protected QueryService queryService;
	
	@Autowired
	public QueryController(QueryService qSvc) {
		queryService = qSvc;
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Query>> findByCategory(@RequestParam("category") String category){
		logger.info(String.format("query-service findByCategory invoked for {} for category '{}'", 
				QueryController.class,
				category));
		List<Query> queries;
		if(category != null) {
			category = category.trim().toLowerCase();
		}
		try {
			if(category != null && "".equals(category)) {
				queries = queryService.getAll();
			}else {
				queries = queryService.findByCategory(category);
			}			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return queries != null ? new ResponseEntity<>(queries, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Query>> findById(@PathVariable("id") String id){
		logger.info(String.format("query-service findById invoked for {}: for id {}", 
				QueryController.class, id));
		
		Optional<Query> query;
		try {
			query = queryService.findById(Long.parseLong(id));
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return query != null ? new ResponseEntity<>(query, HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Query> update(@RequestBody QueryVO queryVO){
		logger.info(String.format("query-service update invoked for {}: for id {}", 
				QueryController.class, queryVO));
		
		Optional<Query> optional;
		try {
			optional = queryService.findById(queryVO.getId());
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		Query query = optional.get();
		BeanUtils.copyProperties(queryVO, query);
		try {
			queryService.update(query);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);			
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Query> add(@RequestBody QueryVO queryVO){
		logger.info(String.format("query-service add invoked for {}: for id {}", 
				QueryController.class, queryVO.toString()));
		System.out.println(queryVO);
		Query query = new Query(null, null, null, null);
		BeanUtils.copyProperties(queryVO, query);
		try {
			queryService.add(query);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return query != null ? new ResponseEntity<>(HttpStatus.CREATED) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
