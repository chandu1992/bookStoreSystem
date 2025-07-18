package com.mksss.cummins.bookStoreSystem.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    @Bean
    public UserDetailsService userDetailsService(){
        //{noop} no op password encoder
        UserDetails chandra = User.withUsername("chandra")
                .password("{noop}chandra123")
                .roles("ADMIN")
                .build();

        UserDetails gauri = User.withUsername("gauri")
                .password("{noop}gauri123")
                .roles("DM")
                .build();

        UserDetails vrinda = User.withUsername("vrinda")
                .password("{noop}vrinda123")
                .roles("PM")
                .build();

        UserDetails shriva = User.withUsername("shriva")
                .password("{noop}shriva123")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(chandra,gauri,vrinda,shriva);
    }

}
