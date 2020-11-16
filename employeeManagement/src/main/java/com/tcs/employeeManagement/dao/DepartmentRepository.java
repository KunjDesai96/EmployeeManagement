package com.tcs.employeeManagement.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeManagement.model.Department;


public interface DepartmentRepository {
	public String addDepartment(Department department);
	public String updateDepartment(long id);
	public String deleteDepartment(long id);
	public Optional<Department> findById(long id);
	public Optional<List<Department>> getDepartments();
	public Optional<List<Department>> findByOragnizationId(long id);
}
