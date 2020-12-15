package de.tekup.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.tekup.recipe.services.IngredientService;
import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IngredientController {
	
	private RecipeService serviceRecipe;
	private IngredientService serviceIngredient;
	
	@GetMapping("/recipe/{id}/ingredients")
	public String showRecipeIngredients(@PathVariable("id") long id,
			Model model) {
		model.addAttribute("ingredients", serviceRecipe.getRecipeById(id).getIngredients());
		model.addAttribute("recipeId", id);
		return "recipe/ingredients/show";
	}
	
	@GetMapping("/recipe/{recipeId}/ingredient/{id}/delete")
	public String deleteRecipe(@PathVariable("recipeId") long recipeId,@PathVariable("id") long id) {
		serviceIngredient.deleteIngredient(id);
		return "redirect:/recipe/"+recipeId+"/ingredients";
	}

}
