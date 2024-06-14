package com.spring.survey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long Id;
	private String title;
	
	
}
