package de.tekup.recipe.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.recipe.dto.models.RecipeRequest;
import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class RecipeController {
	
	private RecipeService recipeService;
	
	@GetMapping("/recipe/{id}/show")
	public String getShowRecipe(@PathVariable("id") long id, Model model) {
		System.out.println(recipeService.getRecipeById(id));
		model.addAttribute("recipe", recipeService.getRecipeById(id));
		return "recipe/show";
	}
	
	
	@GetMapping("/recipe/{id}/delete")
	public String deleteRecipe(@PathVariable("id") long id) {
		recipeService.deleteRecipe(id);
		return "redirect:/";
	}
	// Show Form
	@GetMapping("/recipe/add")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeRequest());
		return "recipe/recipeform";
	}
	
	//Handle Submitted form
	@PostMapping("/recipe")
	public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeRequest request,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//display in console to check
			bindingResult.getAllErrors().forEach(System.err::println);
			return "recipe/recipeform";
		}
		recipeService.saveRecipeInDB(request);
		return "redirect:/";
	}

}
