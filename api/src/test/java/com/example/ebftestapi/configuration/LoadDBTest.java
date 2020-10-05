package com.example.ebftestapi.configuration;

import com.example.ebftestapi.storage.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoadDBTest {

  @Autowired
  EmployeeRepository employeeRepo;


  @Test
  public void initDatabase() {
    LoadDB db = new LoadDB();
    db.initDatabase();

    assertNotNull(employeeRepo.findByEmail("jes@gmail.com"));
  }
}
