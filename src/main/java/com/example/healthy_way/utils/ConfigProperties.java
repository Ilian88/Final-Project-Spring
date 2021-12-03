package com.example.healthy_way.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class ConfigProperties {

    private String username;

    private String password;

    private String driverClassName;

    private String url;

    public ConfigProperties() {
    }

    public String getUsername() {
        return username;
    }

    public ConfigProperties setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ConfigProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public ConfigProperties setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ConfigProperties setUrl(String url) {
        this.url = url;
        return this;
    }
}
