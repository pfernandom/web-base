package com.untitled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.untitled.security.repo.CustomUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
@EntityScan(basePackages = { "com.untitled.security.entity" }) 
@EnableJpaRepositories(basePackages = { "com.untitled.security.repo" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().cacheControl().disable();
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/css/**", "/login*.html", "/logout*", "/webjars/**", "/static/**").permitAll()
			.antMatchers("/**").fullyAuthenticated()
			.antMatchers("/user**").hasRole("USER")
			.antMatchers("/admin**").hasRole("ADMIN")
			.and()
            .formLogin()
              .loginPage("/login.html")
              .loginProcessingUrl("/login")
              .failureUrl("/login-error.html")
              .defaultSuccessUrl("/")
            .and()
            .logout().logoutSuccessUrl("/login.html");
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
		return new BCryptPasswordEncoder();
	}
	
}