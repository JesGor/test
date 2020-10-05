package com.example.ebfoauth.configuration;

import com.example.ebfoauth.entity.Company;
import com.example.ebfoauth.entity.Role;
import com.example.ebfoauth.entity.User;
import com.example.ebfoauth.storage.CompanyRepository;
import com.example.ebfoauth.storage.RoleRepository;
import com.example.ebfoauth.storage.UserRepository;
import com.example.ebfoauth.type.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to load some initial data to database
 *
 * @author jesus
 */
@Configuration
public class LoadDB {
  /**
   * Repository of Company Entity
   */
  @Autowired
  private CompanyRepository companyRepo;

  /**
   * Repository of Role Entity
   */
  @Autowired
  private RoleRepository roleRepo;

  /**
   * Repository of User Entity
   */
  @Autowired
  private UserRepository userRepo;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  /**
   * Method to initialize database with some data
   *
   * @return CommandLineRunner
   */
  @Bean
  CommandLineRunner initDatabase() {
    return args -> {
      Company company = new Company("Company1");
      company = createCompanyIfNotFound(company);
      Role role = createRoleIfNotFound(RoleType.ROLE_ADMIN);
      List<Role> roles = new ArrayList<Role>();
      roles.add(role);
      User user = new User("admin", "$2y$10$bUOmpjB.UN8HFAemlYwIGOuvMTJ2rgLQubAzfe7ER3Bhr.mGkJVvS", company, roles);
      createUserIfNotFound(user);

      Company company2 = new Company("Company2");
      company2 = createCompanyIfNotFound(company2);
      User user2 = new User("jes", "$2y$10$bUOmpjB.UN8HFAemlYwIGOuvMTJ2rgLQubAzfe7ER3Bhr.mGkJVvS", company2, roles);
      createUserIfNotFound(user2);
    };
  }

  /**
   * Method to check if role is already in the database, if not then creates it
   *
   * @param roletype the role from enum
   * @return Role the role found or created
   */
  @Transactional
  Role createRoleIfNotFound(RoleType roletype) {
    Role role = roleRepo.findByName(roletype);
    if (role == null) {
      role = new Role(roletype);
      roleRepo.save(role);
    }
    return role;
  }

  /**
   * Method to check if User is already in the database, if not then creates it
   *
   * @param newUser the user that is going to be checked
   * @return User the user found or created
   */
  @Transactional
  User createUserIfNotFound(User newUser) {
    User user = userRepo.findByUsername(newUser.getUsername());
    if (user == null) {
      user = newUser;
    } else {
      user.setRoles(newUser.getRoles());
    }
    userRepo.save(user);
    return user;
  }

  /**
   * Method to check if Company is already in the database, if not then creates it
   *
   * @param newComp the company that is going to be checked
   * @return Company the company found or created
   */
  @Transactional
  Company createCompanyIfNotFound(Company newComp) {
    Company comp = companyRepo.findByName(newComp.getName());
    if (comp == null) {
      comp = newComp;
      companyRepo.save(comp);
    }
    return comp;
  }
}
