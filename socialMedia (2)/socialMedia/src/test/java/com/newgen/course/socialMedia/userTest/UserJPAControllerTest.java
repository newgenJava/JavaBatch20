package com.newgen.course.socialMedia.userTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.course.socialMedia.controller.UserJPAController;
import com.newgen.course.socialMedia.model.User;
import com.newgen.course.socialMedia.repository.UserRepository;

@WebMvcTest(UserJPAController.class)
public class UserJPAControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testFindAllUsers() throws Exception {
		List<User> mockUsers = List.of(new User(10000, "Alice", "alice@newgen.com", LocalDate.of(1995, 1, 1), null),
				new User(10001, "John", "john@newgen.com", LocalDate.of(1992, 1, 1), null));

		Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

		mockMvc.perform(get("/jpa/users")).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(mockUsers.size()))
				.andExpect(jsonPath("$[0].name").value("Alice"))
				.andExpect(jsonPath("$[0].email").value("alice@newgen.com"))
				.andExpect(jsonPath("$[1].name").value("John"));
	}

	@Test
	public void testFindOneUser() throws Exception {
		int userId = 1;
		User mockUser = new User(userId, "John", "john@newgen.com", LocalDate.of(1992, 1, 1), null);

		Mockito.when(userRepository.existsById(userId)).thenReturn(true);
		Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

		mockMvc.perform(get("/jpa/users/{id}", userId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value(mockUser.getName()))
				.andExpect(jsonPath("$.email").value(mockUser.getEmail()))
				.andExpect(jsonPath("$.birthDate").value("1992-01-01"));
	}

	@Test
	public void testFindOneUserNotFound() throws Exception {
		int userId = 99;

		Mockito.when(userRepository.existsById(userId)).thenReturn(false);

		mockMvc.perform(get("/jpa/users/{id}", userId)).andExpect(status().isNotFound());

		Mockito.verify(userRepository).existsById(userId);
		Mockito.verify(userRepository, Mockito.never()).findById(userId);

	}

	@Test
	public void testCreateUser() throws Exception {

		User newUser = new User(null, "John", "john@newgen.com", LocalDate.of(1992, 1, 1), null);
		
		Mockito.when(null).thenReturn(newUser);
		mockMvc.perform(
				post("/jpa/users").contentType("application/json").content(objectMapper.writeValueAsString(newUser)))
				.andExpect(status().isCreated());
	}
}
