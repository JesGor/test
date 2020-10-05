package com.example.ebfoauth.service;

import com.example.ebfoauth.entity.User;
import com.example.ebfoauth.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;

/**
 * Class for the User details service
 *
 * @author jesus
 */
public class UserDetailsServiceImpl implements UserDetailsService {

  /**
   * Repository of user entity
   */
  @Autowired
  private UserRepository userRepo;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return new UserDetailImpl(user);
  }
}
