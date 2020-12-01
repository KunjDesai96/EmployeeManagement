package com.tcs.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeManagement.repository.EmployeeRepository;
import com.tcs.employeeManagement.model.Employee;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	EmployeeRepository empR;
	
	@Override
	public Employee addEmployeee(Employee employee) {
		return empR.save(employee);
	}


	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		empR.deleteById((int) id);
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return empR.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(empR.findAll());
	}

	@Override
	public Optional<List<Employee>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		return empR.findByOrganizationId(id);
	}

}
