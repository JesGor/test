package com.example.ebftestapi.storage;

import com.example.ebftestapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class for the Repository of companies
 *
 * @author jesus
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
  /**
   * Find a company by a giving name
   *
   * @param name company name
   * @return Company the company found
   */
  Company findByName(String name);
}
