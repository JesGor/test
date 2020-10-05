package com.example.ebfoauth.storage;

import com.example.ebfoauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class that implements the interface for Repository of users
 *
 * @author jesus
 */
public interface UserRepository extends JpaRepository<User, Long> {
  /**
   * Find User by a giving username
   *
   * @param username username of the user
   * @return User user found
   */
  User findByUsername(String username);
}
