package com.taskproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)//404
public class UserNotFound extends RuntimeException{
      
	private String message;
	
	//create constructor
	public UserNotFound(String message) {
		super(message);
		this.message=message;
		
	}
}
