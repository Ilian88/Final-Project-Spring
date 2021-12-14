package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.entity.Like;
import com.example.healthy_way.repository.LikeRepository;
import com.example.healthy_way.service.LikeService;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public boolean addLike(String recipeId) {
        Like like = new Like();


        return false;
    }
}
