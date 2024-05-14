package com.tpeterb.cookbook.core.recipe.persistence.entity;

import com.tpeterb.cookbook.core.recipe.ingredient.persistence.entity.Ingredient;
import com.tpeterb.cookbook.core.recipe.model.CookingComplexity;
import com.tpeterb.cookbook.core.recipe.model.NutritionFact;
import com.tpeterb.cookbook.core.recipe.model.RecipeCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;

    private String description;

    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;

    private Integer servings;

    private Integer totalCookingTimeInMinutes;

    @Enumerated(EnumType.STRING)
    private CookingComplexity cookingComplexity;

    @Embedded
    private NutritionFact nutritionFact;

    public Recipe(String name,
                  List<Ingredient> ingredients,
                  String description,
                  RecipeCategory recipeCategory,
                  Integer servings,
                  Integer totalCookingTimeInMinutes,
                  CookingComplexity cookingComplexity,
                  NutritionFact nutritionFact) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.recipeCategory = recipeCategory;
        this.servings = servings;
        this.totalCookingTimeInMinutes = totalCookingTimeInMinutes;
        this.cookingComplexity = cookingComplexity;
        this.nutritionFact = nutritionFact;
    }

}
