package com.tcs.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tcs.employeeManagement.model.Department;
import com.tcs.employeeManagement.repository.DepartmentRepository;

@Service
public class DepartmentServicesImpl implements DepartmentServices {

	@Autowired
	DepartmentRepository deptR;
	
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			deptR.save(department);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Failure";
	}

	@Override
	public String updateDepartment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
