package com.tpeterb.cookbook.core.recipe.ingredient.model;

import lombok.Value;

@Value
public class IngredientDTO {

    String name;

    String unitOfMeasurement;

    Integer quantity;

}
