package de.tekup.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class RecipeController {
	
	private RecipeService recipeService;
	
	@GetMapping("/recipe/{id}/show")
	public String getShowRecipe(@PathVariable("id") long id, Model model) {
		
		return "recipe/show";
	}

}
