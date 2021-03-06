package com.example.healthy_way.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {

    private String name;

    private String imageURL;

    private String textContent;

    private String shorDescription;

    private List<Like> likes;

    private LocalDateTime createdOn;

    private UserEntity author;

    public Recipe() {
    }

    @Column(name = "name",nullable = false,unique = true)
    @Size(min = 3,max = 25)
    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "image_url")
    @NotNull
    public String getImageURL() {
        return imageURL;
    }

    public Recipe setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    @Column(name = "text_content",columnDefinition = "TEXT",nullable = false)
    @Size(min = 20,max = 1500)
    public String getTextContent() {
        return textContent;
    }

    public Recipe setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @Column(name = "short_description",nullable = false)
    public String getShorDescription() {
        return shorDescription;
    }

    public Recipe setShorDescription(String shorDescription) {
        this.shorDescription = shorDescription;
        return this;
    }

    @Column(name = "created_on")
    @PastOrPresent
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Recipe setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public Recipe setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @OneToMany(mappedBy = "recipe",fetch = FetchType.EAGER)
    public List<Like> getLikes() {
        return likes;
    }

    public Recipe setLikes(List<Like> likes) {
        this.likes = likes;
        return this;
    }
}
