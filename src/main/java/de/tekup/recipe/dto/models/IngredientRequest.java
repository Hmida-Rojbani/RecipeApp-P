package de.tekup.recipe.dto.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class IngredientRequest {
	
	private long id;
	
	@NotBlank
	private String description;
	@Positive
	private Double amount;
	@Valid
	private UnitOfMeasureRequest uom;

}
