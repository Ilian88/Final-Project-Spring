package com.example.healthy_way.web;

import com.example.healthy_way.service.LikeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/add/{rId}")
    public String addLikeRecipe(@PathVariable("rId") String recipeId) {

        this.likeService.addLike(recipeId);

        // TODO : to add the logic in service
    }
}
