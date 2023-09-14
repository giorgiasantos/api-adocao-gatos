package com.example.catalisa.miaumatch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/gatos").permitAll()
                .antMatchers(HttpMethod.POST, "/api/gatos").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/gatos/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/gatos/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/adocao").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST, "/api/adocao").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.PUT, "/api/adocao/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.DELETE, "/api/adocao/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/users").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST, "/api/users").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.PUT, "/api/users/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
