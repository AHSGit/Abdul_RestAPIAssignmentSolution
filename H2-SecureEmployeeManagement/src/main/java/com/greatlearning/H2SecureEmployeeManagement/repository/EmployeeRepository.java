package com.greatlearning.H2SecureEmployeeManagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.H2SecureEmployeeManagement.model.Employee;

// JPA Repository to store employee database
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Custom method for search operation
	List<Employee> findByFirstName(String firstName);

}
