package com.example.healthy_way.model.view;

import com.example.healthy_way.model.entity.UserEntity;

import java.time.LocalDateTime;

public class ArticleViewModel {

    private String id;

    private String title;

    private String textContent;

    private String shortDescription;

    private LocalDateTime createdOn;

    private UserEntity author;

    public ArticleViewModel() {
    }

    public String getId() {
        return id;
    }

    public ArticleViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public ArticleViewModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public ArticleViewModel setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public ArticleViewModel setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public ArticleViewModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }
}
