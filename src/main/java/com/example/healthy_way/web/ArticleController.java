package com.example.healthy_way.web;

import com.example.healthy_way.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public String getArticles(Model model){

        model.addAttribute("articles",this.articleService.getAllArticles());

        return "articles";
    }

    @GetMapping("/get/{id}")
    public String getSingleArticle(@PathVariable("id") String id , Model model) {

        model.addAttribute("_article",this.articleService.getArticleById(id));

        return "single-article";
    }
}
