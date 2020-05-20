package com.example.demo.kbservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.kbservice.domain.entity.KB;
import com.example.demo.kbservice.domain.repository.KBRepository;

@SpringBootApplication
public class KbServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KbServiceApplication.class, args);
	}

	@Autowired
	KBRepository kbRepository;
	
	@Override
	public void run(String... args) throws Exception {
		KB kb = new KB("hoa duties", "HOA", "Long list of duties", "21415315", null);
 		kbRepository.save(kb);
 		System.out.println("item created");
 		Collection<KB> all = kbRepository.findAll();
 		all.forEach(q -> {
 			System.out.println(q.toString());
 		});
		
	}
}
