package com.example.healthy_way.model.entity;

import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user_entities")
public class UserEntity extends BaseEntity{

    private String username;

    private String password;

    private String email;

    private Integer age;

    private GenderEnum genderEnum;

    private RoleEnum role; // TODO: make list of roles

    public UserEntity() {
    }

    @Column(name = "username",nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    public GenderEnum getGenderEnum() {
        return genderEnum;
    }

    public UserEntity setGenderEnum(GenderEnum genderEnum) {
        this.genderEnum = genderEnum;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public UserEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
