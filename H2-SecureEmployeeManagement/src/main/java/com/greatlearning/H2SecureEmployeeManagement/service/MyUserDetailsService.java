package com.greatlearning.H2SecureEmployeeManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.H2SecureEmployeeManagement.model.MyUserDetails;
import com.greatlearning.H2SecureEmployeeManagement.model.User;
import com.greatlearning.H2SecureEmployeeManagement.repository.UserRepository;

// Service class that implement core interface UserDetailsService 
// which loads user-specific data used for authentication purposes
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	// Searches the user repository for username matching the input user credentials
	// User is authenticated when matching details are found
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("No user found: " + username));

		return user.map(MyUserDetails::new).get();
	}

}
