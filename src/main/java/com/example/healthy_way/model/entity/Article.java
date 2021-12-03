package com.example.healthy_way.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity{

    private String title;

    private String textContent;

    private String shortDescription;

    private LocalDateTime createdOn;

    private UserEntity author;

    public Article() {
    }

    @Column(name = "title",nullable = false,unique = true)
    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(name = "text_content",nullable = false,columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public Article setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @Column(name = "short_description",nullable = false)
    public String getShortDescription() {
        return shortDescription;
    }

    public Article setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    @Column(name = "created_on")
    @PastOrPresent
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Article setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public Article setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }
}
