package com.tcs.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tcs.employeeManagement.model.Department;
import com.tcs.employeeManagement.repository.DepartmentRepository;

@Service
public class DepartmentServicesImpl implements DepartmentServices {

	@Autowired
	DepartmentRepository deptR;
	
	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		return deptR.save(department);
	}

	@Override
	public void  deleteDepartment(long id) {
		// TODO Auto-generated method stub
		 deptR.deleteById((int) id);
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return deptR.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(deptR.findAll());
	}

	@Override
	public Optional<List<Department>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		return deptR.findByOrganizationId(id);
	}

}
