package com.tcs.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeManagement.dao.EmployeeRepository;
import com.tcs.employeeManagement.dao.EmployeeRepositoryImpl;
import com.tcs.employeeManagement.model.Employee;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	EmployeeRepository empR;
	
	@Override
	public String addEmployeee(Employee employee) {
		// TODO Auto-generated method stub
		return empR.addEmployeee(employee);
	}

	@Override
	public String updateEmployee(long id) {
		// TODO Auto-generated method stub
		return empR.updateEmployee(id);
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return empR.deleteEmployee(id);
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return empR.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return empR.getEmployees();
	}

	@Override
	public Optional<List<Employee>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		return empR.findByOragnizationId(id);
	}

}
