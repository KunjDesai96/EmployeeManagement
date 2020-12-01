package com.tcs.employeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.employeeManagement.model.Department;
import com.tcs.employeeManagement.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> findByOrganizationId(long id);
	public List<Employee> findByDepartmentId(long id);
	
}
