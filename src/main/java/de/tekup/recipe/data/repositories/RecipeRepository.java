package de.tekup.recipe.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.recipe.data.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
