package com.newgen.course.socialMedia.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.newgen.course.socialMedia.model.User;
import com.newgen.course.socialMedia.repository.UserRepository;

@Component
public class DataSeeder implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		if (userRepository.count() < 10) {
//			userRepository.saveAll(List.of(new User(null, "John Seed", "john.seed@gmail.com", LocalDate.now()),
//					new User(null, "Sarah Seed", "sarah.seed@gmail.com", LocalDate.now())));
//		}
		System.out.println("Data initialised with Seeder");
	}

}
