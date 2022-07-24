package com.greatlearning.H2SecureEmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.H2SecureEmployeeManagement.model.Role;
import com.greatlearning.H2SecureEmployeeManagement.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	// To add a new role
	@PostMapping("/addRole")
	public String addUser(@RequestBody Role role) {
		roleService.addRole(role);
		return "New Role Added: \n" + role;
	}

	// To delete a role
	@DeleteMapping("/deleteRole/{id}")
	public String deleteRole(@PathVariable int id) {
		roleService.deleteRole(id);
		return "Role Deleted with ID: " + id;
	}

}
