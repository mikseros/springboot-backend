package com.mikseros.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mikseros.springboot.exception.ResourceNotFoundException;
import com.mikseros.springboot.model.Employee;
import com.mikseros.springboot.repository.EmployeeRepository;
import com.mikseros.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// Lambda approach:
		// return employeeRepository.findById(id).orElseThrow(() ->
		//				new ResourceNotFoundException("Employee", "Id", id));
		
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// First we need to check whether employee id is exist in DB
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// Save existing employee to DB
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee Id exist in DB
		employeeRepository.findById(id).orElseThrow(() ->
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}
