package com.example.ebfoauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Class with user endpoints
 *
 * @author jesus
 */
@RestController
public class UserController {
  /**
   * Endpoint to return the User authenticated info
   *
   * @param user Principal user authenticated
   * @return 200 User authenticated
   */
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
}
