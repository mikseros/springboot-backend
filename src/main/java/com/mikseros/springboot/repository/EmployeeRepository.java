package com.mikseros.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikseros.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
