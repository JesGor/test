package com.example.ebfoauth.service;

import com.example.ebfoauth.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Class for User details
 *
 * @author jesus
 */
public class UserDetailImpl implements UserDetails {
  /**
   * The user
   */
  private User user;

  /**
   * Constructor
   *
   * @param user user to get the details from
   */
  public UserDetailImpl(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());
  }

  /**
   * Get user id
   *
   * @return Long id of the user
   */
  public Long getId() {
    return user.getId();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  /**
   * Get the company id associated with the user
   *
   * @return Long the company id
   */
  public Long getCompanyId() {
    return user.getCompany().getId();
  }
}
