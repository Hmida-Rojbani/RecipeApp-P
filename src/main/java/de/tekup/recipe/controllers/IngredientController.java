package de.tekup.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.recipe.data.entities.Recipe;
import de.tekup.recipe.dto.models.IngredientRequest;
import de.tekup.recipe.dto.models.UnitOfMeasureRequest;
import de.tekup.recipe.services.IngredientService;
import de.tekup.recipe.services.RecipeService;
import de.tekup.recipe.services.UnitOfMeasureService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IngredientController {
	
	private RecipeService serviceRecipe;
	private IngredientService serviceIngredient;
	private UnitOfMeasureService serviceUom;
	
	@GetMapping("/recipe/{id}/ingredients")
	public String showRecipeIngredients(@PathVariable("id") long id,
			Model model) {
		model.addAttribute("ingredients", serviceRecipe.getRecipeById(id).getIngredients());
		model.addAttribute("recipeId", id);
		return "recipe/ingredients/show";
	}
	
	@GetMapping("/recipe/{recipeId}/ingredient/{id}/delete")
	public String deleteIngredient(@PathVariable("recipeId") long recipeId,@PathVariable("id") long id) {
		serviceIngredient.deleteIngredient(id);
		return "redirect:/recipe/"+recipeId+"/ingredients";
	}
	
	@GetMapping("/recipe/{recipeId}/ingredient/add")
	public String newIngredient(@PathVariable("recipeId") long recipeId,Model model) {
		//make sure we have a good id value
		Recipe recipe = serviceRecipe.getRecipeById(recipeId);
		// todo id not good
		
		//Add of ingredient
		
		IngredientRequest ingredientRequest = new IngredientRequest();
		ingredientRequest.setRecipeId(recipeId);
		ingredientRequest.setUom(new UnitOfMeasureRequest());
		model.addAttribute("ingredient", ingredientRequest);
		model.addAttribute("uomList", serviceUom.getUnitOfMeasures());
		return "recipe/ingredients/ingredientform";
	}
	
	@PostMapping("/recipe/{recipeId}/ingredient")
	public String saveOrUpdateIngredient(@PathVariable("recipeId") long recipeId,
			@ModelAttribute("ingredient") IngredientRequest request) {
		serviceIngredient.saveIngredient(request);
		return "redirect:/recipe/"+request.getRecipeId()+"/ingredients";
	}

}
