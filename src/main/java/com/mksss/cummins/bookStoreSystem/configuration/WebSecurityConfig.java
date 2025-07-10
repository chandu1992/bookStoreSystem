package com.mksss.cummins.bookStoreSystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecuity) throws Exception{
        httpSecuity

                .csrf(csrf -> csrf.disable()) // if disable not csrf token authentication required for POST,PUT,DELETE req
//                .csrf(Customizer.withDefaults()) // csrf token required for authentication for POST,PUT,DELETE
                .authorizeHttpRequests(
                        request->request.anyRequest().authenticated()

                )
//                .formLogin(Customizer.withDefaults()); // provide us login page for authentication
                .httpBasic(Customizer.withDefaults()); // provide us login pop-up for authentication


        return httpSecuity.build();
    }
}
