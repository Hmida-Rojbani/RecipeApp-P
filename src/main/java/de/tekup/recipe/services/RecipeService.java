package de.tekup.recipe.services;

import java.util.List;

import de.tekup.recipe.data.entities.Recipe;
import de.tekup.recipe.dto.models.RecipeRequest;

public interface RecipeService {
	
	List<Recipe> getRecipes();
	Recipe getRecipeById(long id);
	void deleteRecipe(long id);
	void saveRecipeInDB(RecipeRequest request);

}
