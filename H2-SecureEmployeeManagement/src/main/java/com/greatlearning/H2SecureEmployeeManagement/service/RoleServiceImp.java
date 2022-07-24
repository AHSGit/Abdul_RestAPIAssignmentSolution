package com.greatlearning.H2SecureEmployeeManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.H2SecureEmployeeManagement.model.Role;
import com.greatlearning.H2SecureEmployeeManagement.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	public RoleRepository roleRepository;

	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	public void deleteRole(int id) {
		Optional<Role> fetchedRole = roleRepository.findById(id);
		if (fetchedRole == null)
			try {
				throw new Exception("Role doesn't exist!");
			} catch (Exception e) {
				e.printStackTrace();
			}

		roleRepository.deleteById(id);
	}

}
