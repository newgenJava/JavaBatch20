package com.newgen.course.socialMedia.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
	
	@NotNull(message="Please enter name")
	@Size(min = 5, max = 100, message = "The size of input name is out of bounds, min=5 and max=100")
	private String name;
	
	@NotNull(message="Please enter email")
	@Email(message = "Please enter a well formed email")
	private String email;
	
//	@NotNull(message="Please enter birthDate")
	@Past(message = "Entered birthdate is invalid, enter date from past")
	private LocalDate birthDate;
}
