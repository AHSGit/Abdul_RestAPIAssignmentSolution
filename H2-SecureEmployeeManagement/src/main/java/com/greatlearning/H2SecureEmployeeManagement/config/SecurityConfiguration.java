package com.greatlearning.H2SecureEmployeeManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	// AUTHENTICATION
	// Using instance of UserDetailsService
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	// AUTHORIZATION
	// Based on roles and authorities
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests()

				.antMatchers("/addRole", "/addUser", "/deleteRole/**", "/listAllUsers", "/getUserById/**",
						"/getUserByUserName/**", "/updateUser/**", "/deleteUser/**", "/addEmployee",
						"/updateEmployee/**", "/deleteEmployee/**")
				.hasAuthority("ADMIN")

				.antMatchers("/listAllEmployees", "/getEmployeeById/**", "/getEmployeeByName/**",
						"/sortEmployeesByFirstName")
				.hasAnyAuthority("USER", "ADMIN")

				.and().csrf().disable();
	}

	// BCryptPasswordEncoder to encode passwords
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

}
