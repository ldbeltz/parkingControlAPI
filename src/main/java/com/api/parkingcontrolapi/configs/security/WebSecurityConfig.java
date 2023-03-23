package com.api.parkingcontrolapi.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET,"/parking-spot/**").permitAll()
//                .requestMatchers(HttpMethod.POST,"/parking-spot").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    //Configuração para auth em memória
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder().encode("12345"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

//  Declarando o PasswordEncoder como @Bean o Spring já reconhece como autenticador e o utiliza sem precisar especificalo no filterChain
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
