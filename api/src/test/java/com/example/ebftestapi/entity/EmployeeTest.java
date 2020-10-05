package com.example.ebftestapi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

  @Test
  void getAndSetId() {
    Employee emp = new Employee();
    emp.setId(Long.valueOf(1));

    assertEquals(Long.valueOf(1), emp.getId());
  }

  @Test
  void getAndSetName() {
    Employee emp = new Employee();
    emp.setName("test");

    assertEquals("test", emp.getName());
  }

  @Test
  void getAndSetSurname() {
    Employee emp = new Employee();
    emp.setSurname("test");

    assertEquals("test", emp.getSurname());
  }

  @Test
  void getAndSetEmail() {
    Employee emp = new Employee();
    emp.setEmail("test@mail.com");

    assertEquals("test@mail.com", emp.getEmail());
  }

  @Test
  void getAndSetAddress() {
    Employee emp = new Employee();
    emp.setAddress("test");

    assertEquals("test", emp.getAddress());
  }

  @Test
  void getAndSetSalary() {
    Employee emp = new Employee();
    emp.setSalary(500);

    assertEquals(500, emp.getSalary());
  }

  @Test
  void getAndSetCompany() {
    Employee emp = new Employee();
    Company company = new Company();
    company.setId(Long.valueOf(5));
    company.setName("test");

    emp.setCompany(company);

    assertNotNull(emp.getCompany());
    assertEquals("test", emp.getCompany().getName());
  }
}
