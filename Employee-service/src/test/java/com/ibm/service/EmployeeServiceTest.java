package com.ibm.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.ibm.Entity.Employee;
import com.ibm.repo.EmployeeRepository;

class EmployeeServiceTest {

	@Test
	void testCreateEmployee() {
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		Employee employee = new Employee();
		String empid = employeeService.createEmployee(employee);
		assertNotNull(empid);
	}

}
