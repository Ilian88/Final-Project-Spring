package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.binding.ArticleBindingModel;
import com.example.healthy_way.model.entity.Article;
import com.example.healthy_way.model.view.ArticleViewModel;
import com.example.healthy_way.repository.ArticleRepository;
import com.example.healthy_way.service.ArticleService;
import com.example.healthy_way.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper, UserService userService) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public List<ArticleViewModel> getAllArticles() {
        return this.articleRepository.findAll()
                .stream()
                .map(a -> modelMapper.map(a,ArticleViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ArticleViewModel getArticleById(String id) {
        return modelMapper.map(this.articleRepository.getById(id),ArticleViewModel.class);
    }

    @Override
    public void saveArticle(ArticleBindingModel articleBindingModel) {
        Article article = modelMapper.map(articleBindingModel,Article.class);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        article.setAuthor(this.userService.findUserByUsername(auth.getName()));

        article.setCreatedOn(LocalDateTime.now());

        this.articleRepository.save(article);
    }

    @Override
    public void editArticle(String articleId, ArticleBindingModel articleBindingModel) {

        Article article = this.articleRepository.findById(articleId).orElseThrow();

        updateArticleValues(article,articleBindingModel);

        this.articleRepository.save(article);
        //TODO : check
    }

    private void updateArticleValues(Article article, ArticleBindingModel articleBindingModel) {
        article.setTitle(articleBindingModel.getTitle())
                .setShortDescription(articleBindingModel.getShortDescription())
                .setTextContent(articleBindingModel.getTextContent());
    }
}
