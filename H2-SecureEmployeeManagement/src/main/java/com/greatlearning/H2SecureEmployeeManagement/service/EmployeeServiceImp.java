package com.greatlearning.H2SecureEmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.H2SecureEmployeeManagement.model.Employee;
import com.greatlearning.H2SecureEmployeeManagement.repository.EmployeeRepository;

// Service class for service level operations 
// that are implemented in the controller classes
@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	public Employee addEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	public List<Employee> listAllEmployees() {
		return empRepository.findAll();
	}

	public Optional<Employee> listEmployeeById(int id) {
		return empRepository.findById(id);
	}

	public List<Employee> listEmployeeByFirstName(String firstName) {
		return empRepository.findByFirstName(firstName);
	}

	public void deleteEmployee(int id) {
		empRepository.deleteById(id);		
	}

	public Employee updateEmployee(Employee employee) {
		Employee tempEmp = empRepository.getById(employee.getId());
		tempEmp.setFirstName(employee.getFirstName());
		tempEmp.setLastName(employee.getLastName());
		tempEmp.setEmail(employee.getEmail());
		return empRepository.save(tempEmp);
	}

	public List<Employee> listAllEmployeesSortedByFirstName(Direction direction) {
		return empRepository.findAll(Sort.by(direction, "firstName"));
	}


	
	

}
