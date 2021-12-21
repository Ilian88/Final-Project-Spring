package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.repository.UserRepository;
import com.example.healthy_way.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserService userService;

    private UserEntity testUser;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userRepository, modelMapper, passwordEncoder);
        testUser = new UserEntity();
        testUser
                .setUsername("testUser")
                .setPassword("12345")
                .setAge(22)
                .setGenderEnum(GenderEnum.MALE)
                .setRole(RoleEnum.ADMIN)
                .setEmail("test@abv.bg");
        userRepository.save(testUser);

    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> userService.findUserByUsername("not valid username")
        );
    }

    @Test
    void testUserFound() {

        Mockito.when(
                        userRepository.findByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        Assertions.assertEquals(
                testUser.getUsername(),
                userService.findUserByUsername("testUser").getUsername());
    }

    @Test
    void testGetAllUsernames() {
        Mockito.when(
                userRepository.getAllUsernames()
        ).thenReturn(
                List.of(testUser.getUsername())
        );

        Assertions.assertEquals(
                List.of(testUser.getUsername()),
                userService.getAllUsernames()
        );
    }
}
