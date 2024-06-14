package com.taskproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskproject.payload.UserDto;
import com.taskproject.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userservice;
	
	//POST method to store the data in DB
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto) {
		return new ResponseEntity<>(userservice.createUser(userdto),HttpStatus.CREATED);
	}

}
