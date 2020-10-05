package com.example.ebftestui.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * Class to define the security configuration
 *
 * @author jesus
 */
@Configuration
@EnableOAuth2Sso
@EnableZuulProxy
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .logout().logoutSuccessUrl("/")
      .and()
      .authorizeRequests()
      .antMatchers("/", "/app.html", "/index.html", "/user", "/home", "/login", "/*.js").permitAll()
      .anyRequest().authenticated()
      .and()
      .csrf()
      .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
  }
}

