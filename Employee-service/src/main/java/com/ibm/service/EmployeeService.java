package com.ibm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.Entity.Employee;
import com.ibm.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public String createEmployee(Employee employee) {
		Employee savedEmp = employeeRepository.save(employee);
		return savedEmp.getId();
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployee(String id) {
		return employeeRepository.findById(id);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	public void deleteEmployee(String id) {
		employeeRepository.deleteById(id);
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}
