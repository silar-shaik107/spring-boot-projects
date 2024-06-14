package com.recipes.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipes.entities.Recipe;
import com.recipes.respository.IRecipeRepository;
import com.recipes.services.IRecipeService;

@Service
public class RecipeServiceImpl implements IRecipeService {
	
	@Autowired
	IRecipeRepository iRecipeRepository;

	@Override
	public List<Recipe> getAllRecipes() {
		
		return iRecipeRepository.findAll() ;
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		
		return iRecipeRepository.save(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		
		iRecipeRepository.save(recipe);
	}

	@Override
	public void deleteRecipe(int recipeId) {
		
		iRecipeRepository.deleteById(recipeId);
	}

	@Override
	public Recipe getRecipeDetails(int recipeId) {
		
		return iRecipeRepository.findById(recipeId).get();
	}

}
