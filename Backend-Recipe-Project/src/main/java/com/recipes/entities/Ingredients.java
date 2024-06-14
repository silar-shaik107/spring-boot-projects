package com.recipes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ingredientsList;

}
