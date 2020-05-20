package com.example.demo.query;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.query.domain.entity.Query;
import com.example.demo.query.domain.repository.QueryRepository;

@SpringBootApplication
@EnableEurekaClient
public class QueryServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(QueryServiceApplication.class, args);
	}

	@Autowired
	QueryRepository queryRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		Query query = new Query("test", "mortgage", "does my hoa include taxes", "21415315");
// 		queryRepository.save(query);
// 		System.out.println("item created");
 		Collection<Query> all = queryRepository.findAll();
 		all.forEach(q -> {
 			System.out.println(q.toString());
 		});
		
	}
	
	

}
