package de.tekup.recipe.services;

import de.tekup.recipe.dto.models.IngredientRequest;

public interface IngredientService {

	void deleteIngredient(long id);
	void saveIngredient(IngredientRequest  ingredientRequest);
}
