package com.example.ebftestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Class with a basic controller
 *
 * @author jesus
 */
@RestController
public class BaseController {

  /**
   * Endpoint of the base url to return a hello world
   *
   * @return
   */
  @GetMapping("/")
  public Map<String, Object> home() {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("id", "api");
    model.put("content", "Hello World");
    return model;
  }


}
