package de.tekup.recipe.dto.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class IngredientRequest {
	
	private long id;
	
	@NotBlank
	private String description;
	@Positive
	private Double amount;
	@Valid
	private UnitOfMeasureRequest uom;
	
	private Long recipeId;

}
