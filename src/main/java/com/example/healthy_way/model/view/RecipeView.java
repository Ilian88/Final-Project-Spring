package com.example.healthy_way.model.view;

import com.example.healthy_way.model.entity.UserEntity;

import java.time.LocalDateTime;

public class RecipeView {

    private String name;

    private String imageURL;

    private String textContent;

    private String shorDescription;

    private LocalDateTime createdOn;

    private UserEntity author;

    public RecipeView() {
    }

    public String getName() {
        return name;
    }

    public RecipeView setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public RecipeView setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public RecipeView setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public String getShorDescription() {
        return shorDescription;
    }

    public RecipeView setShorDescription(String shorDescription) {
        this.shorDescription = shorDescription;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public RecipeView setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RecipeView setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }
}
