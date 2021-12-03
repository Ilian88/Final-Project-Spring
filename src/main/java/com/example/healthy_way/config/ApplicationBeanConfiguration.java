package com.example.healthy_way.config;

import com.example.healthy_way.utils.ConfigProperties;
import org.modelmapper.ModelMapper;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class ApplicationBeanConfiguration {

    private final ConfigProperties configProperties;

    public ApplicationBeanConfiguration(ConfigProperties configProperties) {
        this.configProperties = configProperties;

    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();

        dataSource
                .driverClassName(configProperties.getDriverClassName())
                .url(configProperties.getUrl())
                .username(configProperties.getUsername())
                .password(configProperties.getPassword());

        return dataSource.build();
    }
}
