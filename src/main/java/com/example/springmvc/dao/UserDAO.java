package com.example.springmvc.dao;

import com.example.springmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDAO extends JpaRepository<User, Integer> {

    UserDetails findUserByUsername(String username);
}