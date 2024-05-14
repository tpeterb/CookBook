package com.tpeterb.cookbook.core.recipe;

import com.tpeterb.cookbook.core.recipe.model.RecipeDTO;
import com.tpeterb.cookbook.core.recipe.persistence.entity.Recipe;
import com.tpeterb.cookbook.core.recipe.persistence.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public void createRecipe(RecipeDTO recipeDto) {
        Recipe recipe = convertFromDtoToEntity(recipeDto);
        recipeRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> updateRecipe(Recipe newRecipe) {
        Optional<Recipe> recipe = recipeRepository.findById(newRecipe.getId());
        if (recipe.isPresent()) {
            Recipe recipeToUpdate = recipe.get();
            recipeToUpdate.setName(newRecipe.getName());
            recipeToUpdate.setIngredients(newRecipe.getIngredients());
            recipeToUpdate.setDescription(newRecipe.getDescription());
            recipeToUpdate.setRecipeCategory(newRecipe.getRecipeCategory());
            recipeToUpdate.setServings(newRecipe.getServings());
            recipeToUpdate.setTotalCookingTimeInMinutes(newRecipe.getTotalCookingTimeInMinutes());
            recipeToUpdate.setCookingComplexity(newRecipe.getCookingComplexity());
            recipeToUpdate.setNutritionFact(newRecipe.getNutritionFact());
            recipeRepository.save(recipeToUpdate);
            return Optional.of(recipeToUpdate);
        }
        return Optional.empty();
    }

    @Override
    public List<Recipe> retrieveAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return recipe;
        };
        return Optional.empty();
    }

    @Override
    public void deleteAllRecipes() {
        recipeRepository.deleteAll();
    }

    @Override
    public void deleteRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        recipe.ifPresent(recipeRepository::delete);
    }

    private RecipeDTO convertFromEntityToDto(Recipe recipe) {
        return new RecipeDTO(
                recipe.getName(),
                recipe.getIngredients(),
                recipe.getDescription(),
                recipe.getRecipeCategory(),
                recipe.getServings(),
                recipe.getTotalCookingTimeInMinutes(),
                recipe.getCookingComplexity(),
                recipe.getNutritionFact()
        );
    }

    private Recipe convertFromDtoToEntity(RecipeDTO recipeDto) {
        return new Recipe(
            recipeDto.getName(),
            recipeDto.getIngredients(),
            recipeDto.getDescription(),
            recipeDto.getRecipeCategory(),
            recipeDto.getServings(),
            recipeDto.getTotalCookingTimeInMinutes(),
            recipeDto.getCookingComplexity(),
            recipeDto.getNutritionFact()
        );
    }

}
