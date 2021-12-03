package com.example.healthy_way.service;

import com.example.healthy_way.model.binding.AddRoleBindingModel;
import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.serviceModel.UserServiceModel;

import java.util.List;

public interface UserService {

    void saveUser(UserServiceModel userService);

    boolean checkIfUserExistsByEmail(String email);

    UserEntity findUserByUsername(String username);

    List<String> getAllUsernames();

    void changeRoleOfUser(AddRoleBindingModel addRoleBindingModel);
}
