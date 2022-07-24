package com.greatlearning.H2SecureEmployeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.H2SecureEmployeeManagement.model.Employee;
import com.greatlearning.H2SecureEmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// To add a new employee
	@PostMapping("/addEmployee")
	public String addEmp(@RequestBody Employee employee) {
		empService.addEmployee(employee);
		return "New Employee Added! \n" + employee;
	}

	// To list all employees
	@GetMapping("/listAllEmployees")
	public List<Employee> allEmployees() {
		return empService.listAllEmployees();
	}

	// To fetch employee by ID
	@GetMapping("/getEmployeeById/{id}")
	public Optional<Employee> listEmployeeById(@PathVariable int id) {
		return empService.listEmployeeById(id);
	}

	// To fetch employee by first name
	@GetMapping("/getEmployeeByName/{firstName}")
	public List<Employee> listEmployeeByFirstName(@PathVariable String firstName) {
		return empService.listEmployeeByFirstName(firstName);
	}

	// To get a sorted list of employees based on first name
	// ASC = Ascending, DESC = Descending
	@GetMapping("/sortEmployeesByFirstName")
	public List<Employee> listEmployeesSortedByFirstName(Direction sort) {
		return empService.listAllEmployeesSortedByFirstName(sort);
	}

	// To update an existing employee record
	@PutMapping("/updateEmployee")
	public String updateEmp(@RequestBody Employee employee) {
		empService.updateEmployee(employee);
		return "Updated employee: \n" + employee;
	}

	// To delete an employee record
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmp(@PathVariable int id, Employee employee) {
		empService.deleteEmployee(id);
		return "Deleted Employee with ID: " + id;
	}

}
