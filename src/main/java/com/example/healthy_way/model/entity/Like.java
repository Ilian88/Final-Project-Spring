package com.example.healthy_way.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like extends BaseEntity {

    private UserEntity author;

    private LocalDateTime createdOn;

    private Long number = 0L;

    public Like() {
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public Like setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @PastOrPresent
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Like setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @Min(0)
    public Long getNumber() {
        return number;
    }

    public Like setNumber(Long number) {
        this.number = number;
        return this;
    }
}
