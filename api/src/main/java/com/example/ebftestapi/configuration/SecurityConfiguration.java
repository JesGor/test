package com.example.ebftestapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Class to define the security configuration
 * @author jesus
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(final WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/", "/api-docs/**", "/configuration/ui",
      "/swagger-resources/**",
      "/configuration/security",
      "/swagger-ui.html",
      "/webjars/**",
      "/swagger-ui/**");
  }

}

