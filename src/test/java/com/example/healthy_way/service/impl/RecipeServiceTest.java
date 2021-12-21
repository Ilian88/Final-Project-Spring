package com.example.healthy_way.service.impl;

import com.example.healthy_way.model.entity.Recipe;
import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.repository.RecipeRepository;
import com.example.healthy_way.service.RecipeService;
import com.example.healthy_way.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;

public class RecipeServiceTest {

    private RecipeService recipeService;

    private Recipe recipe;

    @Mock
    private RecipeRepository repository;

    @Mock
    private UserService userService;

    @Mock
    private ModelMapper modelMapper;


    @BeforeEach
    void init() {
        recipeService = new RecipeServiceImpl(repository,userService,modelMapper);

        UserEntity testUser = new UserEntity();
        testUser
                .setUsername("testUser")
                .setPassword("12345")
                .setAge(22)
                .setGenderEnum(GenderEnum.MALE)
                .setRole(RoleEnum.ADMIN)
                .setEmail("test@abv.bg");

        recipe = new Recipe();
        recipe.setName("testRecipe")
                .setShorDescription("asdasdadad")
                .setTextContent("asdsa dsa dsa dsa dsad sa a ")
                .setCreatedOn(LocalDateTime.now())
                .setAuthor(testUser)
                .setId("1");
    }

    @Test
    void testUserNotFound() {

        Assertions.assertThrows(
                NullPointerException.class,
                () -> recipeService.findById("1234")
        );
    }

    @Test
    void testGetUserById() {

        Mockito.when(
                repository.findById(recipe.getId())
        ).thenReturn(Optional.of(recipe));

        Assertions.assertEquals(
                recipe,
                recipeService.findById(recipe.getId())
        );
    }



}
