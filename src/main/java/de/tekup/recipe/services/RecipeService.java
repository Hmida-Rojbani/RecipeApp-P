package de.tekup.recipe.services;

import java.util.List;

import de.tekup.recipe.data.entities.Recipe;

public interface RecipeService {
	
	List<Recipe> getRecipes();
	Recipe getRecipeById(long id);
	void deleteRecipe(long id);

}
