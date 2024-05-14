package com.tpeterb.cookbook.core.recipe;

import com.tpeterb.cookbook.core.recipe.model.RecipeDTO;
import com.tpeterb.cookbook.core.recipe.persistence.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    void createRecipe(RecipeDTO recipeDTO);

    Optional<Recipe> updateRecipe(Recipe recipe);

    List<Recipe> retrieveAllRecipes();

    Optional<Recipe> getRecipeById(Long Id);

    void deleteAllRecipes();

    void deleteRecipeById(Long id);

}
