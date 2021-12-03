package com.example.healthy_way.service;

import com.example.healthy_way.model.entity.RoleEntity;
import com.example.healthy_way.model.enums.RoleEnum;

import java.util.List;

public interface RoleService {
    RoleEntity findRole(RoleEnum roleEnum);

    List<RoleEntity> findRoles(RoleEnum roleEnum);

}
