package com.newgen.course.socialMedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import com.newgen.course.socialMedia.SocialMediaApplication;
import com.newgen.course.socialMedia.exception.UserNotFoundException;
import com.newgen.course.socialMedia.model.Post;
import com.newgen.course.socialMedia.model.PostDTO;
import com.newgen.course.socialMedia.model.User;
import com.newgen.course.socialMedia.model.UserDTO;
import com.newgen.course.socialMedia.repository.PostRepository;
import com.newgen.course.socialMedia.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jpa/users")
public class UserJPAController {

	private final SocialMediaApplication socialMediaApplication;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserJPAController.class);

	UserJPAController(SocialMediaApplication socialMediaApplication) {
		this.socialMediaApplication = socialMediaApplication;
	}

	@GetMapping
	public List<User> findAllJPA() {
		logger.info("Finding all users");
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findOneUserJPA(@PathVariable Integer id) {
		logger.info("findOneUserJPA + fetching user for id + " + id);
		if (!userRepository.existsById(id)) {
			logger.error("User Not Found with id " + id);
			return ResponseEntity.notFound().build();
		}

		var user = userRepository.findById(id).get();
//		logger.info("User found : " + user.toString());
		return ResponseEntity.ok(user);
	}

	@GetMapping("/email/{email}")
	public Optional<User> findOneUserJPA(@PathVariable String email) {
		return userRepository.findByEmail(email);
	}

	@PostMapping
	public User createUserJPA(@Valid @RequestBody User userInp) {
		User userCreated = userRepository.save(userInp);
		return userCreated;
	}

	@PostMapping(params = "version=3")
	public User createUserJPA(@Valid @RequestBody UserDTO userInp) {

		User userTobeCreated = new User();
		userTobeCreated.setBirthDate(userInp.getBirthDate());
		userTobeCreated.setEmail(userInp.getEmail());
		userTobeCreated.setName(userInp.getName());

		User userCreated = userRepository.save(userTobeCreated);
		return userCreated;
	}

	@PostMapping(params = "version=2")
	public ResponseEntity<Object> createUserJPAv2(@RequestHeader Map<String, String> headersInp,
			@RequestBody User userInp) {
		if (headersInp.keySet().stream().anyMatch(key -> key.equalsIgnoreCase("CustomHeader"))) {
			userInp.setName(userInp.getName() + "_" + headersInp.get("CustomHeader".toLowerCase()));
		}
		User userCreated = userRepository.save(userInp);

		UriComponents uriLoc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userCreated.getId());

		var headers = new HttpHeaders();
		headers.add("ApplicationVersion", "2");
		return ResponseEntity.created(uriLoc.toUri()).headers(headers).build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<User> updateUserNameEmail(@RequestBody User userInp, @PathVariable Integer id) {

//		if (!userRepository.existsById(id)) {
//			throw new UserNotFoundException("User with id " + id + " not found", "1001");
//		}
		var headers = new HttpHeaders();
		User userFound = null;
		ResponseEntity<User> response = new ResponseEntity<User>(null);
		try {
			userFound = userRepository.findById(id)
					.orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found", "1001"));
//		User userFound = userFoundOpt.get();
			userFound.setName(userInp.getName());
			userFound.setEmail(userInp.getEmail());

			userRepository.save(userFound);
			response = ResponseEntity.ok(userFound);
		} catch (Exception ex) {
			// update kar do exception details within headers
			headers.add("ErrorDetails", ex.getLocalizedMessage());
		} finally {
			if (headers.containsKey("ErrorDetails"))
				;
			{
				response = ResponseEntity.notFound().headers(headers).build();
			}
		}

		return response;
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> crudUser(@RequestBody User userInp, @PathVariable Integer id) {

		if (!userRepository.existsById(id)) {
//			userInp.setId(id);
			userRepository.save(userInp);

			UriComponents uriLoc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(userInp.getId());

			return ResponseEntity.created(uriLoc.toUri()).build();
		}

		Optional<User> userFoundOpt = userRepository.findById(id);
		User userFound = userFoundOpt.get();
		userFound.setName(userInp.getName());
		userFound.setEmail(userInp.getEmail());

		userRepository.save(userFound);

		return ResponseEntity.ok(userFound);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("formusers")
	public String createUserForm(@ModelAttribute @Valid UserDTO userInp, BindingResult result) {

		if (result.hasErrors()) {
			return "formPage";
		}
		User userTobeCreated = new User();
		userTobeCreated.setBirthDate(userInp.getBirthDate());
		userTobeCreated.setEmail(userInp.getEmail());
		userTobeCreated.setName(userInp.getName());

		User userCreated = userRepository.save(userTobeCreated);
		return "Success";
	}

	@PostMapping("/{userId}/posts")
	public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody PostDTO postInp) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(String.valueOf(userId), "1"));
		
		Post post = new Post();
		
		post.setContents(postInp.getContents());
		post.setUser(user);
		Post savedPost = postRepository.save(post);
		return ResponseEntity.ok(savedPost);
	}
	

}
