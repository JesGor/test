package com.example.ebftestapi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {


  @Test
  void getAndSetId() {
    Company company = new Company();
    company.setId(Long.valueOf(1));

    assertEquals(Long.valueOf(1), company.getId());
  }

  @Test
  void getAndSetName() {
    Company company = new Company();
    company.setName("testing");

    assertEquals("testing", company.getName());
  }
}
