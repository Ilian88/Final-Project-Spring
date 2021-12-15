package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.entity.Like;
import com.example.healthy_way.repository.LikeRepository;
import com.example.healthy_way.service.LikeService;
import com.example.healthy_way.service.RecipeService;
import com.example.healthy_way.service.UserService;
import com.example.healthy_way.utils.AuthProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final RecipeService recipeService;
    private final UserService userService;

    public LikeServiceImpl(LikeRepository likeRepository, RecipeService recipeService, UserService userService) {
        this.likeRepository = likeRepository;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @Override
    public void addLikeRecipe(String recipeId) {
        Like like = new Like();

        like.setCreatedOn(LocalDateTime.now())
                .setRecipe(this.recipeService.findById(recipeId))
                .setAuthor(this.userService.findUserByUsername(AuthProvider.getAuth().getName()));

        this.likeRepository.save(like);
    }
}
