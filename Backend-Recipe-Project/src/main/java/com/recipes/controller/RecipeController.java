package com.recipes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recipes.entities.Recipe;
import com.recipes.exception.RecipeNotFoundException;
import com.recipes.respository.IRecipeRepository;
import com.recipes.services.IRecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	IRecipeService iRecipeService;

	@Autowired
	IRecipeRepository iRecipeRepository;

	@GetMapping("/allRecipes")
	public ResponseEntity<?> getAllRecipes() throws RecipeNotFoundException {

		if (!iRecipeRepository.findAll().isEmpty()) {
			return new ResponseEntity<>(iRecipeService.getAllRecipes(), HttpStatus.OK);
		} else {
			throw new RecipeNotFoundException("No recipes in the list");
		}
	}

	@PostMapping("/addRecipe")
	public ResponseEntity<?> cretateRecipe(@RequestBody Recipe recipe) throws RecipeNotFoundException {

		Optional<Recipe> opt = iRecipeRepository.findByName(recipe.getName());

		if (opt.isPresent()) {
			throw new RecipeNotFoundException("Recipe is alredy creted");
		} else {
			iRecipeService.saveRecipe(recipe);

			return new ResponseEntity<>("Recipe is added in the list", HttpStatus.CREATED);
		}
	}

	@PutMapping("/updateRecipe/{recipeId}")
	public ResponseEntity<?> updateRecipe(@RequestBody Recipe recipe) throws RecipeNotFoundException {

		if (iRecipeRepository.existsById(recipe.getRecipeId())) {
			iRecipeService.updateRecipe(recipe);
			return new ResponseEntity<>("Recipe Id" + recipe.getRecipeId() + "is updated succesfully",
					HttpStatus.ACCEPTED);
		} else {
			throw new RecipeNotFoundException("Recipe id" + recipe.getRecipeId() + "is not found");
		}

	}

	public ResponseEntity<String> deleteRecipe(@PathVariable("recipeId") int recipeId) throws RecipeNotFoundException {
		Optional<Recipe> opt = iRecipeRepository.findById(recipeId);

		if (opt.isPresent()) {
			iRecipeService.deleteRecipe(recipeId);
			return new ResponseEntity<>("Recipe id:" + recipeId + "is deleted succesfully", HttpStatus.OK);
		} else {
			throw new RecipeNotFoundException("Recipe Id:" + recipeId + "is not found");
		}
	}

}
