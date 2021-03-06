package com.example.healthy_way.security;

import com.example.healthy_way.model.entity.UserEntity;
import com.example.healthy_way.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginUserDetails implements UserDetailsService {

    private final UserService userService;

    public LoginUserDetails(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userService.findUserByUsername(username);

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(userEntity.getRole().toString()));


       User user =  new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );

       return user;
    }
}
