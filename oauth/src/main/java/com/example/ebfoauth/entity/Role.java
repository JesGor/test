package com.example.ebfoauth.entity;

import com.example.ebfoauth.type.RoleType;

import javax.persistence.*;

/**
 * Class for the Role Entity
 *
 * @author jesus
 */
@Entity
@Table(name = "role")
public class Role {

  /**
   * Id of the role
   */
  @Id
  @GeneratedValue
  private Long id;

  /**
   * Type of the role
   */
  @Enumerated(EnumType.STRING)
  private RoleType name;

  /**
   * Constructor
   */
  public Role() {

  }

  /**
   * Constructor
   *
   * @param name type of the role
   */
  public Role(RoleType name) {
    this.name = name;
  }

  /**
   * Get role id
   *
   * @return Long the id of the role
   */
  public Long getId() {
    return id;
  }

  /**
   * Set role id
   *
   * @param id the id of the role
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get the role name
   *
   * @return RoleType name of the role
   */
  public RoleType getName() {
    return name;
  }

  /**
   * Set role name
   *
   * @param name the name of the role
   */
  public void setName(RoleType name) {
    this.name = name;
  }
}
