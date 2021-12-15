package com.example.healthy_way.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthProvider {

    public static Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
