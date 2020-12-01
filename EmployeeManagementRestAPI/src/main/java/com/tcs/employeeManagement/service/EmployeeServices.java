package com.tcs.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeManagement.model.Employee;

public interface EmployeeServices {

	public Employee addEmployeee(Employee employee);
	public void deleteEmployee(long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOragnizationId(long id);
}
