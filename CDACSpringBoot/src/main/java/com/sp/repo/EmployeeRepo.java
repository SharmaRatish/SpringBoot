package com.sp.repo;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	

}
