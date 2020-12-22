package de.tekup.recipe.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.recipe.data.entities.Ingredient;
import de.tekup.recipe.data.repositories.IngredientRepository;
import de.tekup.recipe.dto.models.IngredientRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

	private IngredientRepository reposIngredient;
	private ModelMapper mapper;
	
	@Override
	public void deleteIngredient(long id) {
		reposIngredient.deleteById(id);

	}

	@Override
	public void saveIngredient(IngredientRequest ingredientRequest) {
	Ingredient ingEntity = mapper.map(ingredientRequest, Ingredient.class);

	ingEntity=reposIngredient.save(ingEntity);
	
	}

}
