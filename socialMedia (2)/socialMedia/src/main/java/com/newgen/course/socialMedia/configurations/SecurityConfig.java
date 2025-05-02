package com.newgen.course.socialMedia.configurations;

import java.util.List;

import com.newgen.course.socialMedia.exception.MethodArgumentValidationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final MethodArgumentValidationHandler methodArgumentValidationHandler;

    SecurityConfig(MethodArgumentValidationHandler methodArgumentValidationHandler) {
        this.methodArgumentValidationHandler = methodArgumentValidationHandler;
    }
	
	@Bean
	SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests( auth -> 
				auth.requestMatchers("/jpa/users/**").authenticated()
				.anyRequest().permitAll()
				)
		.httpBasic(Customizer.withDefaults())
		.csrf(csrf -> csrf.disable());
		
		return http.build();
	}

	
	@Bean
	UserDetailsService userDeatilsService() {
		UserDetails adminUser = User
				.withUsername("admin")
				.password("{noop}password")
				.roles("ADMIN")
				.build();
		
		UserDetails normalUser = User
				.withUsername("user")
				.password("{noop}user")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(adminUser,normalUser);
	}

}
