package com.example.ebftestapi.storage;

import com.example.ebftestapi.entity.Company;
import com.example.ebftestapi.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeRepositoryTest {

  @Autowired
  EmployeeRepository employeeRepo;
  @Autowired
  CompanyRepository companyRepo;


  @Test
  void findByIdAndCompanyId() {
    Employee emp = new Employee();
    emp.setName("test");
    emp.setSurname("test");
    emp.setSalary(500);
    emp.setAddress("test");
    emp.setEmail(UUID.randomUUID().toString() + "@gmail.com");

    Company company = new Company();
    company.setName(UUID.randomUUID().toString());
    company = companyRepo.save(company);

    emp.setCompany(company);

    emp = employeeRepo.save(emp);

    assertNotNull(employeeRepo.findByIdAndCompanyId(emp.getId(), company.getId()));
  }

  @Test
  void findByEmail() {
    Employee emp = new Employee();
    emp.setName("test");
    emp.setSurname("test");
    emp.setSalary(500);
    emp.setAddress("test");
    String email = UUID.randomUUID().toString() + "@gmail.com";
    emp.setEmail(email);

    Company company = new Company();
    company.setName(UUID.randomUUID().toString());
    company = companyRepo.save(company);

    emp.setCompany(company);

    emp = employeeRepo.save(emp);

    assertNotNull(employeeRepo.findByEmail(email));
  }

  @Test
  void deleteByIdAndCompanyId() {
    Employee emp = new Employee();
    emp.setName("test");
    emp.setSurname("test");
    emp.setSalary(500);
    emp.setAddress("test");
    emp.setEmail(UUID.randomUUID().toString() + "@gmail.com");

    Company company = new Company();
    company.setName(UUID.randomUUID().toString());
    company = companyRepo.save(company);

    emp.setCompany(company);

    emp = employeeRepo.save(emp);

    assertNotNull(employeeRepo.findById(emp.getId()));

    employeeRepo.deleteByIdAndCompanyId(emp.getId(), company.getId());

    assertEquals(Optional.empty(), employeeRepo.findById(emp.getId()));
  }

  @Test
  void getAvgSalaryByCompanyId() {
    Employee emp = new Employee();
    emp.setName("test");
    emp.setSurname("test");
    emp.setSalary(500);
    emp.setAddress("test");
    emp.setEmail(UUID.randomUUID().toString() + "@gmail.com");


    Employee emp2 = new Employee();
    emp2.setName("test");
    emp2.setSurname("test");
    emp2.setSalary(600);
    emp2.setAddress("test");
    emp2.setEmail(UUID.randomUUID().toString() + "@gmail.com");

    Company company = new Company();
    company.setName(UUID.randomUUID().toString());
    company = companyRepo.save(company);

    emp.setCompany(company);
    emp2.setCompany(company);

    emp = employeeRepo.save(emp);
    emp2 = employeeRepo.save(emp2);

    assertEquals(550, employeeRepo.getAvgSalaryByCompanyId(company.getId()));
  }
}
