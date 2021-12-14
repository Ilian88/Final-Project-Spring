package com.example.healthy_way.service;

import com.example.healthy_way.model.binding.AddArticleBindingModel;
import com.example.healthy_way.model.view.ArticleViewModel;

import java.util.List;

public interface ArticleService {

    List<ArticleViewModel> getAllArticles();

    ArticleViewModel getArticleById(String id);

    void saveArticle(AddArticleBindingModel articleBindingModel);
}
