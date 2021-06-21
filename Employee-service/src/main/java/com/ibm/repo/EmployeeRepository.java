package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.Entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
