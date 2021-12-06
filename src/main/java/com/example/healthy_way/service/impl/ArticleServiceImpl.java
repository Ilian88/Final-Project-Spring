package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.view.ArticleViewModel;
import com.example.healthy_way.repository.ArticleRepository;
import com.example.healthy_way.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
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
}
