package com.example.healthy_way.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    @Autowired(required = false)
    public String index(Authentication authentication) {
        if (authentication != null) {
            return "home";
        }

        return "index";
    }

}
