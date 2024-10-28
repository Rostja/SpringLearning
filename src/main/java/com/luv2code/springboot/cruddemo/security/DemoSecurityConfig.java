package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

        );

        //use basic HTTP authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, Put, DElete and/or Patch
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
