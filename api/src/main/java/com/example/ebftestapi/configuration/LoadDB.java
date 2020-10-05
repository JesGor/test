package com.example.ebftestapi.configuration;

import com.example.ebftestapi.entity.Company;
import com.example.ebftestapi.entity.Employee;
import com.example.ebftestapi.storage.CompanyRepository;
import com.example.ebftestapi.storage.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

/**
 * Class to load some initial data to database
 */
@Configuration
public class LoadDB {

  /**
   * Repository of companies
   */
  @Autowired
  private CompanyRepository companyRepo;

  /**
   * Repository of employees
   */
  @Autowired
  private EmployeeRepository employeeRepo;

  /**
   * Method to initialize the database with some data
   *
   * @return CommandLineRunner
   */
  @Bean
  public CommandLineRunner initDatabase() {
    return args -> {
      Company company = new Company("Company1");
      company = createCompanyIfNotFound(company);
      Employee emp = new Employee("Jes", "Pri", "jes@gmail.com", "Fake address", 500, company);
      createEmployeeIfNotFound(emp);

      Company company2 = new Company("Company2");
      company2 = createCompanyIfNotFound(company2);
      Employee emp2 = new Employee("Pri", "Jes", "pri@gmail.com", "Fake address", 500, company2);
      createEmployeeIfNotFound(emp2);
    };
  }

  /**
   * Method to check if Employee is already in the database, if not then creates it
   *
   * @param newEmp
   * @return
   */
  @Transactional
  public Employee createEmployeeIfNotFound(Employee newEmp) {
    Employee emp = employeeRepo.findByEmail(newEmp.getEmail());
    if (emp == null) {
      emp = newEmp;
      employeeRepo.save(newEmp);
    }
    return emp;
  }

  /**
   * Method to check if Company is already in the database, if not then creates it
   *
   * @param newComp the company that is going to be checked
   * @return Company the company found or created
   */
  @Transactional
  public Company createCompanyIfNotFound(Company newComp) {
    Company comp = companyRepo.findByName(newComp.getName());
    if (comp == null) {
      comp = newComp;
      companyRepo.save(comp);
    }
    return comp;
  }

}
