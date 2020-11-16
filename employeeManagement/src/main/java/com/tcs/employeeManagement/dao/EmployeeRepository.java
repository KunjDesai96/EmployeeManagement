package com.tcs.employeeManagement.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeManagement.model.Employee;

public interface EmployeeRepository {

	public String addEmployeee(Employee employee);
	public String updateEmployee(long id);
	public String deleteEmployee(long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOragnizationId(long id);
	public List<Employee> findByDepartmentById(long id);
	
}
