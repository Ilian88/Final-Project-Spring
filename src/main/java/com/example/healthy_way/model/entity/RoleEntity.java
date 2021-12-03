package com.example.healthy_way.model.entity;

import com.example.healthy_way.model.enums.RoleEnum;

import javax.persistence.*;


@Entity
@Table(name="roles")
public class RoleEntity extends BaseEntity{

    private RoleEnum role;

    private UserEntity user;


    public RoleEntity() {
    }

    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public RoleEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public RoleEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
