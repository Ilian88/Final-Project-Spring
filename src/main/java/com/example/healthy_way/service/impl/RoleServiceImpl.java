package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.entity.RoleEntity;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.repository.RoleRepository;
import com.example.healthy_way.service.RoleService;
import com.example.healthy_way.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserService userService;

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity findRole(RoleEnum role) {
        return this.roleRepository.findByRole(role);
    }

    @Override
    public List<RoleEntity> findRoles(RoleEnum roleEnum) {

        List<RoleEntity> roles = new ArrayList<>();

        RoleEntity admin = this.roleRepository.findByRole(RoleEnum.ADMIN);
        RoleEntity moderator = this.roleRepository.findByRole(RoleEnum.MODERATOR);
        RoleEntity user = this.roleRepository.findByRole(RoleEnum.USER);

        if (roleEnum == RoleEnum.ADMIN) {
            roles.addAll(List.of(admin, moderator, user));
        } else if (roleEnum == RoleEnum.MODERATOR) {
            roles.addAll(List.of(moderator, user));
        } else if (roleEnum == RoleEnum.USER) {
            roles.add(user);
        }

        return roles;
    }

}
