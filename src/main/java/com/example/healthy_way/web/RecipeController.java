package com.example.healthy_way.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @GetMapping("/all")
    public String getRecipes() {

        return "recipes";
    }

    @GetMapping("/add")
    public String addRecipe() {

        return "add-recipe";
    }

}
