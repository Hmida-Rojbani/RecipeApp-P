package de.tekup.recipe.data.entities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of ="id")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private LocalTime prepTime;
	private LocalTime cookTime;
	private Integer servings;
	
	@Lob
	private String directions;
	
	@OneToMany(mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
