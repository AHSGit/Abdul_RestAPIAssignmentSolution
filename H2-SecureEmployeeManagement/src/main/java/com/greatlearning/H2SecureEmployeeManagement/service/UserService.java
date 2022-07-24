package com.greatlearning.H2SecureEmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.H2SecureEmployeeManagement.model.User;

public interface UserService {
	
	public List<User> findAllUser();
	
	public Optional<User> findUserById(int id);
	
	public Optional<User> findUserByUserName(String username);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(int id);

}
