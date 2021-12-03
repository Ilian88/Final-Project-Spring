package com.example.healthy_way;

import com.example.healthy_way.model.entity.RoleEntity;
import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.model.enums.GenderEnum;
import com.example.healthy_way.model.enums.RoleEnum;
import com.example.healthy_way.repository.RoleRepository;
import com.example.healthy_way.repository.UserRepository;
import com.example.healthy_way.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitializerDB implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;


    public InitializerDB(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {

        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.count() == 0) {
            RoleEntity admin = new RoleEntity();
            admin.setRole(RoleEnum.ADMIN);

            RoleEntity moderator = new RoleEntity();
            moderator.setRole(RoleEnum.MODERATOR);

            RoleEntity user = new RoleEntity();
            user.setRole(RoleEnum.USER);

            this.roleRepository.saveAll(List.of(admin, moderator, user));
        }

        if (userRepository.count() == 0) {
            UserEntity user1 = new UserEntity();
            user1.setUsername("Iliyan")
                    .setPassword(passwordEncoder.encode("12345"))
                    .setGenderEnum(GenderEnum.MALE)
                    .setAge(33)
                    .setRoles(this.roleService.findRoles(RoleEnum.ADMIN))
                    .setEmail("iliyan.markov@abv.bg");

            this.userRepository.save(user1);
        }


    }

}
