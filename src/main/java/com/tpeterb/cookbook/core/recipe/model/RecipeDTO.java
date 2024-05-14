package com.tpeterb.cookbook.core.recipe.model;

import com.tpeterb.cookbook.core.recipe.ingredient.persistence.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecipeDTO {

    private String name;

    private List<Ingredient> ingredients;

    private String description;

    private RecipeCategory recipeCategory;

    private Integer servings;

    private Integer totalCookingTimeInMinutes;

    private CookingComplexity cookingComplexity;

    private NutritionFact nutritionFact;

}
