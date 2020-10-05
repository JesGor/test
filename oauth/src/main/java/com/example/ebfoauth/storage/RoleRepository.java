package com.example.ebfoauth.storage;

import com.example.ebfoauth.entity.Role;
import com.example.ebfoauth.type.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class that implements the interface for Repository of roles
 *
 * @author jesus
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
  /**
   * Find a Role by a giving name
   *
   * @param name role name
   * @return Role role found
   */
  Role findByName(RoleType name);
}
