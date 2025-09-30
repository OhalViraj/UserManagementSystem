package com.apidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apidemo.model.User;
import com.apidemo.service.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		User saveUser = userServices.saveUser(user);
		if(ObjectUtils.isEmpty(saveUser))
		{
			return new ResponseEntity<>("User Not Save",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getAllUser()
	{
		List<User> allUser = userServices.getAllUser();
		return new ResponseEntity<>(allUser,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		User updateUser = userServices.updateUser(user);
		
		if(ObjectUtils.isEmpty(updateUser))
		{
			return new ResponseEntity<>("user Not Updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(updateUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id)
	{
		userServices.deleteUser(id);
		return new ResponseEntity<>("Delete Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id)
	{
		User userById = userServices.getUserById(id);
		if(ObjectUtils.isEmpty(userById))
		{
			return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userById,HttpStatus.OK);
	}
}
