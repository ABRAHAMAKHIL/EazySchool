package com.easybytes.easyschool.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/home").permitAll()
                		.requestMatchers("/dashboard").authenticated().requestMatchers("/login").permitAll()
                        .requestMatchers("/course").permitAll().requestMatchers("/about").permitAll()
                        .requestMatchers("/contact").permitAll().requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/holiday/**").permitAll().requestMatchers("/assets/**").permitAll());

        http.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/dashboard").permitAll()
                .failureUrl("/login?error=true").permitAll()).logout(logout -> logout.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll());
		http.httpBasic(withDefaults());
		return http.build();
	}
	
	
	@Bean
	InMemoryUserDetailsManager userDetailService() {
		
		
	UserDetails user = 	User.withDefaultPasswordEncoder()
		.username("root")
		.password("root")
		.roles("USER")
		.build();
	UserDetails admin = 	User.withDefaultPasswordEncoder()
			.username("admin")
			.password("admin")
			.roles("USER","ADMIN")
			.build();
		
		
	return new InMemoryUserDetailsManager(user,admin);
		
		
	}
	

}
