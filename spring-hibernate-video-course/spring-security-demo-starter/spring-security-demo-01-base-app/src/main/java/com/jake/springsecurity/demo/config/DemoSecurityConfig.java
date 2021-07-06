package com.jake.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// add reference to securityDataSource from AppConfig.java
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// use jdbc authentication to access db
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		    .antMatchers("/").hasRole("EMPLOYEE")
		    .antMatchers("/managers/**").hasRole("MANAGER")
			.antMatchers("/admins/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateUser")
			.permitAll()					
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}
}
