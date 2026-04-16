package com.mycompany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.mycompany.enums.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain apifilterChain(HttpSecurity http)throws Exception {
		
		return http.securityMatcher("/api/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(request -> request.anyRequest().authenticated())
			.csrf(csrt -> csrt.disable())
			.build();						
	}
	
	
	@Bean
	public SecurityFilterChain webfilterChain(HttpSecurity http)throws Exception {
		
	return	http.securityMatcher("/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
			.authorizeHttpRequests(auth -> auth.requestMatchers("/css/**", "/images/**", "/javascript/**").permitAll()
					.requestMatchers("/admin/**").hasAnyRole(Permiso.ADMINISTRADOR.name())
					.requestMatchers("/login","/sigin").permitAll()
					.anyRequest().permitAll())
		//FIXME Consultar, me tira un error en la url y no me deja loguearme pero si voy a /admin/users desde la url, funciona bien
		.formLogin(page -> page.loginPage("/login").permitAll().defaultSuccessUrl("/login"))
		.build();
		
	}
	 
	
	
	

}
