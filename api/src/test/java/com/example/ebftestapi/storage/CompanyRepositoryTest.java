package com.example.ebftestapi.storage;

import com.example.ebftestapi.entity.Company;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CompanyRepositoryTest {

  @Autowired
  CompanyRepository companyRepo;

  @Test
  void findByName() {
    Company company = new Company();
    String name = UUID.randomUUID().toString();
    company.setName(name);

    companyRepo.save(company);

    assertNotNull(companyRepo.findByName(name));
  }
}
