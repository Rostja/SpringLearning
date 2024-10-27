package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    // Add your custom security configuration here...
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails michal = User.builder()
                .username("michal")
                .password("{noop}tiger123")
                .roles("EMPLOYEE")
                .build();

        UserDetails maria = User.builder()
                .username("maria")
                .password("{noop}tiger123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails zuzana = User.builder()
                .username("zuzana")
                .password("{noop}tiger123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(michal,maria,zuzana);
    }
}
