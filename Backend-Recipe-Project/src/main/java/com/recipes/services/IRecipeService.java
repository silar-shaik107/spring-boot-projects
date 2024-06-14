package com.recipes.services;

import java.util.List;

import com.recipes.entities.Recipe;

public interface IRecipeService {
	
    public List<Recipe> getAllRecipes();
    
    public Recipe saveRecipe(Recipe recipe);
    
    public void updateRecipe(Recipe recipe);
    
    public void deleteRecipe(int recipeId);
    
    public Recipe getRecipeDetails(int recipeId);
}

