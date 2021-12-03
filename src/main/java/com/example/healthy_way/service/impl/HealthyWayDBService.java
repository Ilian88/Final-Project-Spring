package com.example.healthy_way.service.impl;


import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HealthyWayDBService implements UserDetailsService {

    private final UserRepository userRepository;

    public HealthyWayDBService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User with name" + username + "doesn't exist!"));

        return mapToUserDetails(userEntity);

    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {
        List<GrantedAuthority> authorities = userEntity.getRoles()
                .stream()
                .map(u -> new SimpleGrantedAuthority(u.getRole().name()))
                .collect(Collectors.toList());


        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );

    }
}
