package br.hkprogrammer.fullstack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((authz) -> {
			try {
				authz.requestMatchers(HttpMethod.POST, "/users").permitAll().requestMatchers(HttpMethod.POST, "/login")
						.permitAll().anyRequest().authenticated().and().cors();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return http.build();
	}

}
