package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.view.RecipeView;
import com.example.healthy_way.repository.RecipeRepository;
import com.example.healthy_way.service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RecipeView> getAll() {
        return this.recipeRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r,RecipeView.class))
                .collect(Collectors.toList());
    }
}
