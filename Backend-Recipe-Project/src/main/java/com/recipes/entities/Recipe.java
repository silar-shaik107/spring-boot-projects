package com.recipes.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recipeId;
	
	private String name;
	
	@JsonFormat
	private LocalDate created;
	
	private boolean veg;
	
	private int servings;
	
	private String instructions;
	
	@OneToMany(targetEntity = Ingredients.class, cascade = CascadeType.ALL)
	@JoinColumn(name ="RI_fk",referencedColumnName = "recipeId")
	private List<Ingredients> ingredientsList;

}
