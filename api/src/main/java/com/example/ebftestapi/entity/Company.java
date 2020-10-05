package com.example.ebftestapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Class for the Company Entity
 *
 * @author jesus
 */
@Entity
@Table(name = "company")
public class Company {

  /**
   * Company id
   */
  @Id
  @GeneratedValue
  private Long id;

  /**
   * Company name
   */
  @NotEmpty
  @Column(nullable = false, unique = true)
  private String name;

  /**
   * Constructor
   */
  public Company() {

  }

  /**
   * Constructor
   *
   * @param name name of the company
   */
  public Company(String name) {
    this.name = name;
  }

  /**
   * Get company id
   *
   * @return Long the company id
   */
  public Long getId() {
    return id;
  }

  /**
   * Set company id
   *
   * @param id the company id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get company name
   *
   * @return String the company name
   */
  public String getName() {
    return name;
  }

  /**
   * Set company name
   *
   * @param name the company name
   */
  public void setName(String name) {
    this.name = name;
  }
}
