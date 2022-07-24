package com.greatlearning.H2SecureEmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.H2SecureEmployeeManagement.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> listAllEmployees();
	
	public Optional<Employee> listEmployeeById(int id);
	
	public List<Employee> listEmployeeByFirstName(String firstName);
	
	public void deleteEmployee(int id);
	
	public Employee updateEmployee(Employee employee);

	public List<Employee> listAllEmployeesSortedByFirstName(Direction direction);

}
