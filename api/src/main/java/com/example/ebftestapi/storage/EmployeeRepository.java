package com.example.ebftestapi.storage;

import com.example.ebftestapi.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Class for the Repository of Employees
 *
 * @author jesus
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  /**
   * Find employee from a company by a giving company id
   *
   * @param companyId the id of the company
   * @param pageable  paging parameter
   * @return Employee the employee found
   */
  List<Employee> findByCompanyId(Long companyId, Pageable pageable);

  /**
   * Find employee by a giving employee id and a company id
   *
   * @param id        the id of the employee
   * @param companyId the id of the company
   * @return Optional<Employee> Employee found or empty if not
   */
  Optional<Employee> findByIdAndCompanyId(Long id, Long companyId);

  /**
   * Find employee by a giving email
   *
   * @param email the email of the employee
   * @return Employee the employee found
   */
  Employee findByEmail(String email);

  /**
   * Delete employee by a giving employee id and company id
   *
   * @param id        the id of the employee
   * @param companyId the id of the company
   */
  @Transactional
  void deleteByIdAndCompanyId(Long id, Long companyId);

  /**
   * Get the average salary from a company
   *
   * @param companyId the id of the company
   * @return float the average salary
   */
  @Query(value = "SELECT AVG(e.salary) FROM employee e WHERE e.company_id = ?1", nativeQuery = true)
  float getAvgSalaryByCompanyId(Long companyId);
}
