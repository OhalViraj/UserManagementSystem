package com.apidemo.service;

import java.util.List;

import com.apidemo.model.User;

public interface UserServices {
	public User saveUser(User user);
	
	public List<User> getAllUser();
	
	public User updateUser(User user);
	
	public void deleteUser(Integer id);
	
	public User getUserById(Integer id);
}
