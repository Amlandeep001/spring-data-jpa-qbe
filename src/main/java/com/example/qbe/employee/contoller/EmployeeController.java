package com.example.qbe.employee.contoller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qbe.employee.Employee;
import com.example.qbe.employee.exception.EmployeeNotFoundException;
import com.example.qbe.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}

	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchEmployees(
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String department)
	{
		List<Employee> employees = employeeService
				.findEmployeesWithCustomMatcher(firstName, department);
		return ResponseEntity.ok(employees);
	}

	@PostMapping("/search/example")
	public List<Employee> findByExample(@RequestBody @Valid Employee employee)
	{
		return employeeService.findEmployeesByExample(employee);
	}

	@PostMapping("/search/example/one")
	public Employee findOneByExample(@RequestBody @Valid Employee employee)
	{
		return employeeService.findOneEmployeeByExample(employee)
				.orElseThrow(() -> new EmployeeNotFoundException("No employee found matching the example"));
	}

	@PostMapping("/count")
	public long countByExample(@RequestBody @Valid Employee employee)
	{
		return employeeService.countEmployeesByExample(employee);
	}

	@PostMapping("/exists")
	public boolean existsByExample(@RequestBody @Valid Employee employee)
	{
		return employeeService.existsByExample(employee);
	}

}
