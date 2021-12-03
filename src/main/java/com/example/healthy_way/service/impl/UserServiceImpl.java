package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.binding.AddRoleBindingModel;
import com.example.healthy_way.model.entity.RoleEntity;
import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.model.serviceModel.UserServiceModel;
import com.example.healthy_way.repository.UserRepository;
import com.example.healthy_way.service.RoleService;
import com.example.healthy_way.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserServiceModel userService) {

        boolean notExist = this.userRepository.findByUsername(userService.getUsername()).isEmpty();

        if (notExist) {
            UserEntity user = modelMapper.map(userService, UserEntity.class);

            user.setPassword(passwordEncoder.encode(userService.getPassword()));

            user.setGenderEnum(GenderEnum.valueOf(userService.getGender()))
                    .setRoles(List.of(roleService.findRole(RoleEnum.USER)));

            this.userRepository.save(user);
        }

        //TODO : throw custom exception
    }

    @Override
    public boolean checkIfUserExistsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null); // TODO : custom exception
    }

    @Override
    public List<String> getAllUsernames() {
        return this.userRepository.getAllUsernames();
    }

    @Override
    public void changeRoleOfUser(AddRoleBindingModel addRoleBindingModel) {
        UserEntity user = this.userRepository.findByUsername(addRoleBindingModel.getUsername())
                .orElse(null); //TODO

        List<RoleEntity> roles =  this.roleService.findRoles(RoleEnum.valueOf(
          addRoleBindingModel.getRole()
        ));

        user.setRoles(roles);

        this.userRepository.save(user);

    }


}
