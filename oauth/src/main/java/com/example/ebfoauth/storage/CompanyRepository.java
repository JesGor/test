package com.example.ebfoauth.storage;

import com.example.ebfoauth.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class that implements the interface for Repository of companies
 *
 * @author jesus
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
  /**
   * Find company by a giving name
   *
   * @param name name of the company
   * @return Company company found
   */
  Company findByName(String name);
}
