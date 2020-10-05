package com.example.ebfoauth.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Class for the User entity
 *
 * @author jes
 */
@Entity
@Table(name = "user")
public class User {

  /**
   * Id of the user
   */
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  /**
   * Username of the user
   */
  @NotEmpty
  @Column(nullable = false, unique = true)
  private String username;

  /**
   * Password of the user
   */
  @NotEmpty
  private String password;

  /**
   * Company to which the user belongs
   */
  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

  /**
   * Roles of the user
   */
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "user_role",
    joinColumns = @JoinColumn(
      name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
      name = "role_id", referencedColumnName = "id"))
  private List<Role> roles;

  /**
   * Constructor
   */
  public User() {

  }

  /**
   * Constructor
   *
   * @param username the username of the user
   * @param password the password of the user
   * @param company  the user company
   * @param roles    the roles of the user
   */
  public User(String username, String password, Company company, List<Role> roles) {
    this.username = username;
    this.password = password;
    this.company = company;
    this.roles = roles;
  }

  /**
   * Get user id
   *
   * @return Long the user id
   */
  public Long getId() {
    return id;
  }

  /**
   * Set user id
   *
   * @param id the user id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get user username
   *
   * @return String username of the user
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set user username
   *
   * @param username username of the user
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get user password
   *
   * @return String password of the user
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set user password
   *
   * @param password password of the user
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get user company
   *
   * @return Company company of the user
   */
  public Company getCompany() {
    return company;
  }

  /**
   * Set user company
   *
   * @param company company of the user
   */
  public void setCompany(Company company) {
    this.company = company;
  }

  /**
   * Get user roles
   *
   * @return List<Role> a list of roles of the user
   */
  public List<Role> getRoles() {
    return roles;
  }

  /**
   * Set user roles
   *
   * @param roles a list of roles of the user
   */
  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}
