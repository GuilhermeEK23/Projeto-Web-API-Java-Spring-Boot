package br.com.criandoapi.projeto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
		httpSec
		.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
            .anyRequest().authenticated()
        );
		
		httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
    return httpSec.build();
	}
	
	
}
