package com.example.healthy_way.config;

import com.example.healthy_way.interceptor.LoggerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {

    private final LoggerInterceptor logger;

    public InterceptorConfig(LoggerInterceptor logger) {
        this.logger = logger;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logger);
    }
}
