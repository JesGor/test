package com.example.ebftestapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BaseController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class BaseControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void home() throws Exception {

    RequestBuilder rb;
    rb = MockMvcRequestBuilders
      .get("/");

    MvcResult res = mockMvc.perform(rb).andReturn();

    assertEquals(HttpStatus.OK.value(), res.getResponse().getStatus());

  }
}
