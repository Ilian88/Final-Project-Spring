package com.example.healthy_way.web;

import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.repository.UserRepository;
import com.example.healthy_way.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private UserEntity testUser;

    @BeforeEach
    void setUp() {
        testUser = new UserEntity();
        testUser
                .setUsername("testUser")
                .setPassword("12345")
                .setAge(22)
                .setGenderEnum(GenderEnum.MALE)
                .setRole(RoleEnum.ADMIN)
                .setEmail("test@abv.bg");
    }

    @WithMockUser("Iliyan")
    @Test
    void testGetRegister() throws Exception {
        mockMvc.perform(get("/users/register").with(user("Iliyan").password("12345")
                        .roles(String.valueOf(RoleEnum.ADMIN))))
                .andExpect(status().isOk());


    }

}
