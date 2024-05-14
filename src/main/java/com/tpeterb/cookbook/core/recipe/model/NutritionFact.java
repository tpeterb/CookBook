package com.tpeterb.cookbook.core.recipe.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
public class NutritionFact {

    Integer calories;

    Integer fatInGrams;

    Integer carbsInGrams;

    Integer proteinInGrams;

}
