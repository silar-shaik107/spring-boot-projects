package com.taskproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskManagmentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagmentProjectApplication.class, args);
	}
	
	//ModelMapper which is used to convert Entity <==> Dto
    @Bean
	public ModelMapper modelMapper() {    
		return new ModelMapper();
	}
	
}
