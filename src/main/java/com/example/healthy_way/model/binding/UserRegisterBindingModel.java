package com.example.healthy_way.model.binding;

import com.example.healthy_way.model.enums.GenderEnum;

import javax.validation.constraints.*;

public class UserRegisterBindingModel {

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

    private Integer age;

    private String gender;

    public UserRegisterBindingModel() {
    }

    @NotNull
    @NotBlank
    @Size(min = 3, max = 15)
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @NotBlank
    @Size(min = 3, max = 12)
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Positive
    @NotNull
    public Integer getAge() {
        return age;
    }

    public UserRegisterBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }


    public String getGender() {
        return gender;
    }

    public UserRegisterBindingModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public boolean passwordsMatch() {
        if (this.password == null || this.confirmPassword == null) {
            return false;
        }
        return this.password.equals(this.confirmPassword);
    }
}
