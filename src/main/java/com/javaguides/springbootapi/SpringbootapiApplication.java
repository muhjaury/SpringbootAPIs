package com.javaguides.springbootapi;

import com.javaguides.springbootapi.model.User;
import com.javaguides.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setEmail("user1@gmail.com");
//		user.setPassword("user1");
//		userRepository.save(user);
//
//		User user2 = new User();
//		user2.setEmail("user2@gmail.com");
//		user2.setPassword("user2");
//		userRepository.save(user2);
	}
}
