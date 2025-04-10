package com.newgen.course.socialMedia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newgen.course.socialMedia.model.*;
import com.newgen.course.socialMedia.service.*;

@RestController()
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable Integer id) {
		Optional<User> userFound = userService.findOne(id);

		if (userFound.isEmpty() || !userFound.isPresent()) {
//			throw an error
		}
		return userFound.get();
	}
	
	@PostMapping()
	public User createUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		return userService.update(id,user);
	}
}
