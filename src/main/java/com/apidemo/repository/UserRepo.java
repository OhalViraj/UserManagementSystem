package com.apidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apidemo.model.User;


public interface UserRepo extends JpaRepository<User, Integer>{

	
	
}
