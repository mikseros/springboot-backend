package com.mikseros.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
