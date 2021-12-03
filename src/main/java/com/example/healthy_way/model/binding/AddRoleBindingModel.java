package com.example.healthy_way.model.binding;

public class AddRoleBindingModel {

    private String username;

    private String role;

    public AddRoleBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public AddRoleBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRole() {
        return role;
    }

    public AddRoleBindingModel setRole(String role) {
        this.role = role;
        return this;
    }
}
