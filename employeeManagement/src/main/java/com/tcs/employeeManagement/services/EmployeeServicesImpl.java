package com.tcs.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeManagement.repository.EmployeeRepository;
import com.tcs.employeeManagement.model.Employee;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	EmployeeRepository empR;
	
	@Override
	public String addEmployeee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			empR.save(employee);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Failure";
	}

	@Override
	public String updateEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
