package com.piyush.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.piyush.demo.model.User;

@Component
public interface UserRepository extends JpaRepository<User, String>{

	User findByEmail(String loginemail);
}
