package com.newgen.course.socialMedia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.newgen.course.socialMedia.model.User;
import com.newgen.course.socialMedia.repository.UserRepository;

@RestController
@RequestMapping("/jpa/users")
public class UserJPAController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> findAllJPA() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findOneUserJPA(@PathVariable Integer id) {
		if(!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		var user = userRepository.findById(id).get();
		return ResponseEntity.ok(user);
	}

	@GetMapping("/email/{email}")
	public Optional<User> findOneUserJPA(@PathVariable String email) {
		return userRepository.findByEmail(email);
	}

	@PostMapping
	public User createUserJPA(@RequestBody User userInp) {
		User userCreated = userRepository.save(userInp);
		return userCreated;
	}

	@PostMapping(params = "version=2")
	public ResponseEntity<Object> createUserJPAv2(@RequestBody User userInp) {
		userInp.setName(userInp.getName() + "-Version2");
		User userCreated = userRepository.save(userInp);
		
		UriComponents uriLoc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userCreated.getId());
		
		var headers = new HttpHeaders();
		headers.add("ApplicationVersion", "2");
		return ResponseEntity.created(uriLoc.toUri()).headers(headers).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
