package com.funddoauthorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailService;
	
	@Bean
	public AuthenticationManager getAuthenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
		 //http.csrf().disable().antMatcher("/api/**").authorizeRequests()
	     //   .anyRequest().authenticated();
		 
		 http.csrf().disable().antMatcher("/api/**").authorizeRequests()
	        .antMatchers("/useradmin/**").authenticated();
	  
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
		
	}
	
	

}
