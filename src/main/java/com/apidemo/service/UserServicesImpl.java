package com.apidemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.apidemo.model.User;
import com.apidemo.repository.UserRepo;

@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		User saveUser = userRepo.save(user);
		return saveUser;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> allUser = userRepo.findAll();
		return allUser;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User user2 = userRepo.save(user);
		return user2;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> findById = userRepo.findById(id);
		if(findById.isPresent())
		{
			User user = findById.get();
			userRepo.delete(user);
		}
	
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> getUsetById = userRepo.findById(id);
		
		if(getUsetById.isPresent())
		{
			return getUsetById.get();
		}
		
		return null;
	}
	
	

}
