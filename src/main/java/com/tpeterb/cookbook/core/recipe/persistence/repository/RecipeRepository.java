package com.tpeterb.cookbook.core.recipe.persistence.repository;

import com.tpeterb.cookbook.core.recipe.persistence.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
