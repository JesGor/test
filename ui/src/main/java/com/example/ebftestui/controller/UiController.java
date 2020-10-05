package com.example.ebftestui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

/**
 * Controller of the UI
 *
 * @author jesus
 */
@RestController
public class UiController {

  /**
   * Get the authenticated user
   *
   * @param user the user
   * @return 200 Principal authenticated user
   */
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

  /**
   * Token endpoint
   *
   * @param session HttpSession
   * @return 200 Token with session id
   */
  @RequestMapping("/token")
  public Map<String, String> token(HttpSession session) {
    return Collections.singletonMap("token", session.getId());
  }

}
