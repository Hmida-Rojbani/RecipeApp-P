package de.tekup.recipe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.recipe.data.entities.Recipe;
import de.tekup.recipe.data.repositories.RecipeRepository;
import de.tekup.recipe.exception.NotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository reposRecipe;

	@Override
	public List<Recipe> getRecipes() {
		return reposRecipe.findAll();
	}

	@Override
	public Recipe getRecipeById(long id) {
		
		return reposRecipe.findById(id).orElseThrow(()-> new NotFoundException("Recipe Not Found! For ID value : "+id));
	}

	@Override
	public void deleteRecipe(long id) {
		reposRecipe.deleteById(id);
		
	}

}
