package com.example.healthy_way.model.serviceModel;

import com.example.healthy_way.model.enums.GenderEnum;

public class UserServiceModel {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer age;

    private String gender;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserServiceModel setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
