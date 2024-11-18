package com.udea.sagoa.infra.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.udea.sagoa.dominio.user.model.Permission.*;
import static com.udea.sagoa.dominio.user.model.Role.*;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionAuthenticationStrategy -> sessionAuthenticationStrategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(rQ -> {
                    rQ.requestMatchers(HttpMethod.GET, "/example/admin").hasRole(ADMIN.name());
                    rQ.requestMatchers(HttpMethod.GET, "/example/customer").hasAnyAuthority(CUSTOMER_READ.name(), ADMIN_READ.name());
                    rQ.requestMatchers("/users/**").permitAll();
                    rQ.requestMatchers("/auth/**").permitAll();
                    rQ.anyRequest().authenticated();
                })
                .cors(Customizer.withDefaults())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
