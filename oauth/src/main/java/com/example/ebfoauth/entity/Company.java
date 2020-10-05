package com.example.ebfoauth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class for the Company entity
 *
 * @author jesus
 */
@Entity
@Table(name = "company")
public class Company {

  /**
   * The id of the company
   */
  @Id
  @GeneratedValue
  private Long id;

  /**
   * The name of the company
   */
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
   * @return Long id of the company
   */
  public Long getId() {
    return id;
  }

  /**
   * Set company id
   *
   * @param id id to be set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get company name
   *
   * @return String name of the company
   */
  public String getName() {
    return name;
  }

  /**
   * Set company name
   *
   * @param name name of the company
   */
  public void setName(String name) {
    this.name = name;
  }
}
