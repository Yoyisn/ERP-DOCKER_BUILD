package com.demo.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.erp.models.User;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUserName(String userName);

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    //List<User> findByRoleId(Long roleId);

    //List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

}