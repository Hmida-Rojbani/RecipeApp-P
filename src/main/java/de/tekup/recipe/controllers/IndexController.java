package de.tekup.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	
	private RecipeService recipeService;
	
	@GetMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index"; 
	}

}
