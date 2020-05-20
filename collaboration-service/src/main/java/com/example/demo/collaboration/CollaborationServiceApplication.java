package com.example.demo.collaboration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.collaboration.domain.entity.Post;
import com.example.demo.collaboration.domain.repository.CollaborationRepository;

@SpringBootApplication
@EnableEurekaClient
public class CollaborationServiceApplication implements CommandLineRunner{

	@Autowired
	CollaborationRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CollaborationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Post post = new Post("When you’re building new construction, you’re tasked with making a lot of "
//				+ "decisions. The base price of your home is the cost of the structure plus all the standard "
//				+ "finishes. If you’re planning to customize (and if you’re building a new home, you probably"
//				+ " are), then you have to also factor in the cost of upgrades.",
//					"2", null);
//		repository.save(post);
		
		Collection<Post> posts = repository.findAll();
		posts.forEach(post1 -> {
			System.out.println(post1.toString());
		});
		
	}

}
