package com.example.healthy_way.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity{

    private String title;

    private String imageURL;

    private String textContent;

    private String shorDescription;

    private LocalDateTime createdOn;

    private UserEntity author;

    public Exercise() {
    }

    @Column(name = "title",nullable = false,unique = true)
    public String getTitle() {
        return title;
    }

    public Exercise setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }

    public Exercise setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    @Column(name = "text_content",columnDefinition = "TEXT",nullable = false)
    public String getTextContent() {
        return textContent;
    }

    public Exercise setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @Column(name = "short_descritpion",nullable = false)
    public String getShorDescription() {
        return shorDescription;
    }

    public Exercise setShorDescription(String shorDescription) {
        this.shorDescription = shorDescription;
        return this;
    }

    @Column(name = "created_on")
    @PastOrPresent
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Exercise setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public Exercise setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }
}
