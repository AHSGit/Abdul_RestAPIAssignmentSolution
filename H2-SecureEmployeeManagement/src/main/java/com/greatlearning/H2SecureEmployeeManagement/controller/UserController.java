package com.greatlearning.H2SecureEmployeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.H2SecureEmployeeManagement.model.User;
import com.greatlearning.H2SecureEmployeeManagement.service.UserService;

@RestController
@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {

	@Autowired
	private UserService userService;

	// To add a new user
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return "New User Added: \n" + user;
	}

	// To list all users
	@GetMapping("/listAllUsers")
	public List<User> allUsers() {
		return userService.findAllUser();
	}

	// To fetch an user based on ID
	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return userService.findUserById(id);
	}

	// To fetch an user based on username
	@GetMapping("/getUserByUserName/{username}")
	public Optional<User> getUserByUserName(@PathVariable String username) {
		return userService.findUserByUserName(username);
	}

	// To update an existing user details
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "Updated User: \n" + user;
	}

	// To delete an user
	@DeleteMapping("deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "User Deleted with ID: " + id;
	}

}
