package com.mikseros.springboot.service;

import java.util.List;

import com.mikseros.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
}