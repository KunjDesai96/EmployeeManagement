package com.tcs.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeManagement.model.Department;


public interface DepartmentServices {


	public Department addDepartment(Department department);
	public void deleteDepartment(long id);
	public Optional<Department> findById(long id);
	public Optional<List<Department>> getDepartments();
	public Optional<List<Department>> findByOragnizationId(long id);
}
