package com.example.ebftestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
public class EbfTestApiApplication extends ResourceServerConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(EbfTestApiApplication.class, args);
  }

}
