package com.example.healthy_way.web;

import com.example.healthy_way.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public String getRecipes(Model model) {

        model.addAttribute("recipes",this.recipeService.getAll());

        return "recipes";
    }

    @GetMapping("/add")
    public String addRecipe() {

        return "add-recipe";
    }

}
