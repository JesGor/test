package com.example.ebftestapi.controller;

import com.example.ebftestapi.entity.Employee;
import com.example.ebftestapi.parser.UserDetailDataParser;
import com.example.ebftestapi.storage.CompanyRepository;
import com.example.ebftestapi.storage.EmployeeRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class with the employee endpoints
 *
 * @author jesus
 */
@RestController
public class EmployeeController {

  /**
   * Repository of employees
   */
  @Autowired
  private EmployeeRepository employeeRepo;
  /**
   * Repository of companies
   */
  @Autowired
  private CompanyRepository companyRepo;

  /**
   * EMPLOYEE_ENDPOINT
   */
  private static final String EMPLOYEE_ENDPOINT = "/employees";

  /**
   * Get employee list
   *
   * @param authentication authentication in the request
   * @param pageable       optional parameter for paging
   * @return 200 List of employees inside the company
   */
  @GetMapping(EMPLOYEE_ENDPOINT)
  ResponseEntity getEmployeesByCompanyId(OAuth2Authentication authentication, Pageable pageable) {
    Long companyId = UserDetailDataParser.getCompanyIdFromAuthentication(authentication);
    return new ResponseEntity(employeeRepo.findByCompanyId(companyId, pageable), HttpStatus.OK);
  }

  /**
   * Create new employee
   *
   * @param employee       Employee data from the request body
   * @param authentication authentication in the request
   * @return 201 If the user can be created
   */
  @PostMapping(EMPLOYEE_ENDPOINT)
  ResponseEntity newEmployee(@Valid @RequestBody Employee employee, OAuth2Authentication authentication) {
    Long companyId = UserDetailDataParser.getCompanyIdFromAuthentication(authentication);
    return companyRepo.findById(companyId).map(company -> {
      employee.setCompany(company);
      try {
        return new ResponseEntity(employeeRepo.save(employee), HttpStatus.CREATED);
      } catch (DataIntegrityViolationException ex) {
        String message = ex.getMessage();
        if (ex.getCause() instanceof ConstraintViolationException) {
          String locMessage = ex.getCause().getCause().getLocalizedMessage();
          message = locMessage.substring(0, locMessage.indexOf("' ") + 1);
          throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, message, ex);
        }
        throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, message, ex);
      }
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Company with id " + companyId + " not found"));
  }

  /**
   * Get employee by id
   *
   * @param id             Employee id
   * @param authentication authentication in the request
   * @return 200 If the user is found
   */
  @GetMapping(EMPLOYEE_ENDPOINT + "/{id}")
  ResponseEntity getEmployee(@PathVariable Long id, OAuth2Authentication authentication) {
    Long companyId = UserDetailDataParser.getCompanyIdFromAuthentication(authentication);
    Employee emp = employeeRepo.findByIdAndCompanyId(id, companyId)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with id " + id + " not found"));

    return new ResponseEntity(emp, HttpStatus.OK);
  }

  /**
   * Update employee data if already exist, in case not it will be created
   *
   * @param newEmployee    Employee data in the request body
   * @param id             Employee id to be updated
   * @param authentication authentication in the request
   * @return 200 With the user info
   */
  @PutMapping(EMPLOYEE_ENDPOINT + "/{id}")
  ResponseEntity updateEmployee(@Valid @RequestBody Employee newEmployee, @PathVariable Long id, OAuth2Authentication authentication) {
    Long companyId = UserDetailDataParser.getCompanyIdFromAuthentication(authentication);
    return employeeRepo.findByIdAndCompanyId(id, companyId)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setSurname(newEmployee.getSurname());
        employee.setAddress(newEmployee.getAddress());
        employee.setEmail(newEmployee.getEmail());
        employee.setAddress(newEmployee.getAddress());
        employee.setSalary(newEmployee.getSalary());
        return new ResponseEntity(employeeRepo.save(employee), HttpStatus.OK);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return new ResponseEntity(employeeRepo.save(newEmployee), HttpStatus.OK);
      });
  }

  /**
   * Delete a user by id
   *
   * @param id             User id
   * @param authentication authentication in the request
   * @return 204 No Content
   */
  @DeleteMapping(EMPLOYEE_ENDPOINT + "/{id}")
  ResponseEntity deleteEmployee(@PathVariable Long id, OAuth2Authentication authentication) {
    Long companyId = UserDetailDataParser.getCompanyIdFromAuthentication(authentication);
    employeeRepo.deleteByIdAndCompanyId(id, companyId);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  /**
   * Get the average salary of the company
   *
   * @param authentication authentication in the request
   * @return 200 With the avg salary
   */
  @GetMapping(EMPLOYEE_ENDPOINT + "/avg-salary")
  ResponseEntity getAvgSalary(OAuth2Authentication authentication) {
    Long companyId = UserDetailDataParser.getCompanyIdFromAuthentication(authentication);
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("avg_salary", employeeRepo.getAvgSalaryByCompanyId(companyId));
    return new ResponseEntity(body, HttpStatus.OK);
  }
}
