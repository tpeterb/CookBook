package com.tpeterb.cookbook.core.recipe.ingredient.persistence.repository;

import com.tpeterb.cookbook.core.recipe.ingredient.persistence.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
