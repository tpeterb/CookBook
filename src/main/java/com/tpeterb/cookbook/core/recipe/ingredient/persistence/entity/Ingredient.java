package com.tpeterb.cookbook.core.recipe.ingredient.persistence.entity;

import com.tpeterb.cookbook.core.recipe.persistence.entity.Recipe;
import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer quantity;

    private String unitOfMeasurement;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
