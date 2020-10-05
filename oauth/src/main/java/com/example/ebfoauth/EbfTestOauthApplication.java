package com.example.ebfoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class EbfTestOauthApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(EbfTestOauthApplication.class, args);
  }

}
