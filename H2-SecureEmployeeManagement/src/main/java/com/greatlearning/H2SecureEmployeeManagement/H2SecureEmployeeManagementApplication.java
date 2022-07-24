package com.greatlearning.H2SecureEmployeeManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.greatlearning.H2SecureEmployeeManagement.model.Role;
import com.greatlearning.H2SecureEmployeeManagement.model.User;
import com.greatlearning.H2SecureEmployeeManagement.repository.UserRepository;
import com.greatlearning.H2SecureEmployeeManagement.service.RoleService;
import com.greatlearning.H2SecureEmployeeManagement.service.UserService;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class H2SecureEmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(H2SecureEmployeeManagementApplication.class, args);
	}

	// Inserting the default credentials on startup
	// using Command Line Runner
	@Override
	public void run(String... args) throws Exception {

		Role defaultRole = new Role();
		defaultRole.setName("ADMIN");
		roleService.addRole(defaultRole);

		User defaultUser = new User();
		List<Role> role1 = new ArrayList<>();
		role1.add(0, defaultRole);
		defaultUser.setUsername("admin");
		defaultUser.setPassword("admin");
		defaultUser.setRoles(role1);
		userService.addUser(defaultUser);
		System.out.println("Default credentials loaded!");

	}

}
