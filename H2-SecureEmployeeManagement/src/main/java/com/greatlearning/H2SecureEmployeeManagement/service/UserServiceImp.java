package com.greatlearning.H2SecureEmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.H2SecureEmployeeManagement.model.User;
import com.greatlearning.H2SecureEmployeeManagement.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	public Optional<User> findUserById(int id) {
		return userRepository.findById(id);
	}

	public Optional<User> findUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {

		User tempUser = userRepository.getById(user.getId());
		tempUser.setUsername(user.getUsername());
		tempUser.setPassword(user.getPassword());
		tempUser.setRoles(user.getRoles());

		return userRepository.save(tempUser);
	}

	public void deleteUser(int id) {

		Optional<User> fetchedUser = userRepository.findById(id);
		if (fetchedUser == null)
			try {
				throw new Exception("User not found!");
			} catch (Exception e) {
				e.printStackTrace();
			}

		userRepository.deleteById(id);
	}

}
