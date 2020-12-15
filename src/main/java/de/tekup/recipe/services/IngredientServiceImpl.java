package de.tekup.recipe.services;

import org.springframework.stereotype.Service;

import de.tekup.recipe.data.repositories.IngredientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

	private IngredientRepository reposIngredient;
	
	@Override
	public void deleteIngredient(long id) {
		reposIngredient.deleteById(id);

	}

}
