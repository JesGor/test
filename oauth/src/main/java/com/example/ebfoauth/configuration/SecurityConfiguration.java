package com.example.ebfoauth.configuration;

import com.example.ebfoauth.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Class with the Security configuration
 *
 * @author jesus
 */
@Configuration
@Order(-20)
@EnableAuthorizationServer
@EnableResourceServer
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin().permitAll()
      .and()
      .requestMatchers().antMatchers("/login", "/logout", "/oauth/authorize", "/oauth/confirm_access")
      .and()
      .authorizeRequests().anyRequest().authenticated();
  }

  /**
   * Method to get the UserDetailsService
   *
   * @return UserDetailsServiceImpl the service with user details
   */
  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl();
  }

  /**
   * Method to get the password encoder
   *
   * @return BCryptPasswordEncoder a new password encoder
   */
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Method to set the authentication provider config, user details and password encoder
   *
   * @return DaoAuthenticationProvider authentication provider
   */
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  /**
   * Method to set the authentication provider to the authentication manager builder
   *
   * @param auth the authentication manager builder for authentication
   * @throws Exception
   */
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }
}

