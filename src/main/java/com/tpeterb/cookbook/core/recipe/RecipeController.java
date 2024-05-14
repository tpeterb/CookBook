package com.tpeterb.cookbook.core.recipe;

import com.tpeterb.cookbook.core.recipe.model.RecipeDTO;
import com.tpeterb.cookbook.core.recipe.persistence.entity.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    // Read
    @GetMapping("/index")
    public String showRecipeList(Model model) {
        model.addAttribute("recipeList", recipeService.retrieveAllRecipes());
        return "index";
    }

    @GetMapping("/showNewRecipeForm")
    public String showNewRecipeForm(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "newBook";
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipeService.createRecipe(new RecipeDTO(
                recipe.getName(),
                recipe.getIngredients(),
                recipe.getDescription(),
                recipe.getRecipeCategory(),
                recipe.getServings(),
                recipe.getTotalCookingTimeInMinutes(),
                recipe.getCookingComplexity(),
                recipe.getNutritionFact()
        ));
        return "redirect:/index";
    }

    @GetMapping("/showUpdateFormForRecipe/{recipeId}")
    public String showUpdateFormForRecipe(@PathVariable("recipeId") Long id, Model model) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe.get());
        return "updateRecipe";
    }

    @PostMapping("/updateRecipe")
    public String updateRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipeService.updateRecipe(recipe);
        return "redirect:/index";
    }

    @GetMapping("/deleteRecipe/{recipeId}")
    public String deleteRecipe(@PathVariable("recipeId") Long id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/index";
    }

}
