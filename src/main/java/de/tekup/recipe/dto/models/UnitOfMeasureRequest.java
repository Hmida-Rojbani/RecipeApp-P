package de.tekup.recipe.dto.models;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class UnitOfMeasureRequest {
	
	@NotBlank
	private String description;

}
