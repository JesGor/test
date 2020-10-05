package com.example.ebftestapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Class for the Employee Entity
 *
 * @author jesus
 */
@Entity
@Table(name = "employee")
public class Employee {

  /**
   * Employee id
   */
  @Id
  @GeneratedValue
  private Long id;
  /**
   * Employee name
   */
  @NotEmpty
  @Size(min = 3, max = 30)
  private String name;
  /**
   * Employee surname
   */
  @NotEmpty
  @Size(min = 3, max = 30)
  private String surname;
  /**
   * Employee email
   */
  @NotEmpty
  @Column(nullable = false, unique = true)
  private String email;
  /**
   * Employee address
   */
  @Size(min = 3, max = 60)
  private String address;

  /**
   * Employee salary
   */
  private float salary;

  /**
   * Employee company
   */
  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

  /**
   * Constructor
   */
  public Employee() {
  }

  /**
   * COnstructor
   *
   * @param name    the name of the employee
   * @param surname the surname of the employee
   * @param email   the email of the employee
   * @param address the address of the employee
   * @param salary  the salary of the employee
   * @param company the company of the employee
   */
  public Employee(String name, String surname, String email, String address, float salary, Company company) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.address = address;
    this.salary = salary;
    this.company = company;
  }

  /**
   * Get employee id
   *
   * @return Long the employee id
   */
  public Long getId() {
    return id;
  }

  /**
   * Set employee id
   *
   * @param id the employee id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get employee name
   *
   * @return String name of the employee
   */
  public String getName() {
    return name;
  }

  /**
   * Set employee name
   *
   * @param name name of the employee
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get employee surname
   *
   * @return String the surname of the employee
   */
  public String getSurname() {
    return surname;
  }

  /**
   * Set employee surname
   *
   * @param surname the surname of the employee
   */
  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * Get employee email
   *
   * @return String the email of the employee
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set employee email
   *
   * @param email the email of the employee
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get employee address
   *
   * @return String the address of the employee
   */
  public String getAddress() {
    return address;
  }

  /**
   * Set employee address
   *
   * @param address the address of the employee
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Get employee salary
   *
   * @return float salary of the employee
   */
  public float getSalary() {
    return salary;
  }

  /**
   * Set employee salary
   *
   * @param salary salary of the employee
   */
  public void setSalary(float salary) {
    this.salary = salary;
  }

  /**
   * Get employee company
   *
   * @return Company the company of the employee
   */
  public Company getCompany() {
    return company;
  }

  /**
   * Set employee company
   *
   * @param company the company of the employee
   */
  public void setCompany(Company company) {
    this.company = company;
  }
}
