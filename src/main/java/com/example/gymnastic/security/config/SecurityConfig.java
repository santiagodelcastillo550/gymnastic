package com.example.gymnastic.security.config;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	
	
	  @Bean public UserDetailsManager userDetailsService(DataSource dataSource) {
	  return new JdbcUserDetailsManager(dataSource); }
	  
	  @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	  throws Exception{ log.info("securityFilterChain");
	  
	  http .authorizeHttpRequests(authz -> authz .requestMatchers(HttpMethod.GET,
			  			"/login","/rutinas","/","/style.css", "/img/**",
			  			"/h2-console/**","/register").permitAll() 
			  .requestMatchers(HttpMethod.POST, "/register").permitAll() // Permitir POST a /register
			  .requestMatchers("/admin/**").hasRole("ADMIN")
			  //.requestMatchers("/h2-console/**").hasRole("ADMIN")
			  .anyRequest().authenticated())
	  
	  .formLogin((form) -> form.loginPage("/login") 
	  //.loginProcessingUrl("/login") 
	  .failureUrl("/loginError")
	  .successForwardUrl("/rutinas").permitAll()); http.logout((logout) ->
	  logout.permitAll());
	  
	  http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
	  http.headers(headers -> headers.frameOptions().sameOrigin()); return
	  http.build(); }
	  
	  
	  @Bean public PasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder(); }
	  
	 /* @Bean public DataSource dataSource() { return new EmbeddedDatabaseBuilder()
	  .setType(EmbeddedDatabaseType.H2).build(); }*/
	 
}
