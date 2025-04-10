package com.newgen.course.socialMedia.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{
	
	private final String errorCode;
	
	public UserNotFoundException(String message, String errorCode)
	{
		super(message);
		this.errorCode = errorCode;
	}

}
