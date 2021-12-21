package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.entity.Article;
import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.repository.ArticleRepository;
import com.example.healthy_way.service.ArticleService;
import com.example.healthy_way.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;


public class ArticleServiceTest {

    private ArticleService articleService;

    private Article article;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserService userService;

    @BeforeEach
    void init() {
        articleService = new ArticleServiceImpl(articleRepository,modelMapper,userService);

        UserEntity testUser = new UserEntity();
        testUser
                .setUsername("testUser")
                .setPassword("12345")
                .setAge(22)
                .setGenderEnum(GenderEnum.MALE)
                .setRole(RoleEnum.ADMIN)
                .setEmail("test@abv.bg");

        article = new Article();
        article.setTitle("testArticle")
                .setCreatedOn(LocalDateTime.now())
                .setShortDescription("123213dfs sd f")
                .setTextContent("sdfsdgsd sdg sdg sd gsd g")
                .setAuthor(testUser)
                .setId("1");
    }

    @Test
    void testArticleThrows() {

        Assertions.assertThrows(
                NullPointerException.class,
                () ->  articleService.getArticleById("invalid id")
        );
    }

    @Test
    void testArticle() {

        Mockito.when(
                articleRepository.getById("1")
        ).thenReturn(article);

        Assertions.assertEquals(
                article,
                articleRepository.getById("1")
        );
    }



}
