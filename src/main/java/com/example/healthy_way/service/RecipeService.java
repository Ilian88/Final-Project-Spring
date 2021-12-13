package com.example.healthy_way.service;

import com.example.healthy_way.model.binding.RecipeBindingModel;
import com.example.healthy_way.model.view.RecipeView;

import java.util.List;

public interface RecipeService {
    List<RecipeView> getAll();

    RecipeView getById(String id);

    void addRecipe(RecipeBindingModel recipeBindingModel);
}
