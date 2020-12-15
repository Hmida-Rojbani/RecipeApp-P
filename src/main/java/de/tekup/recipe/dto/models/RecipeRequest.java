package de.tekup.recipe.dto.models;

import java.time.LocalTime;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import de.tekup.recipe.data.entities.Difficulty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeRequest {
	private long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String description;
	
	private LocalTime prepTime;
	private LocalTime cookTime;
	
	@Min(1)
	@Max(25)
	private Integer servings;
	
	@NotBlank
	private String directions;
	
	private Difficulty difficulty;
	
	private Set<IngredientRequest> ingredients;
	
	public void setPrepTime(String time) {
		prepTime = LocalTime.parse(time);
	}
	
	public void setCookTime(String time) {
		cookTime = LocalTime.parse(time);
	}

}
