package com.example.healthy_way.model.entity;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="comments")
public class Comment extends BaseEntity{

    private String content;

    private LocalDateTime createdOn;

    private UserEntity author;

    private List<Like> likes;

    public Comment() {
    }

    @Column(name = "content",columnDefinition = "LONGTEXT")
    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    @PastOrPresent
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Comment setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public Comment setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @OneToMany
    public List<Like> getLikes() {
        return likes;
    }

    public Comment setLikes(List<Like> likes) {
        this.likes = likes;
        return this;
    }
}
