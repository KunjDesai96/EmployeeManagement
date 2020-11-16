package com.tcs.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeManagement.dao.DepartmentRepository;
import com.tcs.employeeManagement.dao.DepartmentRepositoryImpl;
import com.tcs.employeeManagement.model.Department;

@Service
public class DepartmentServicesImpl implements DepartmentServices {

	@Autowired
	DepartmentRepository deptR;
	
	private static DepartmentServices  deptS;
	
	private DepartmentServicesImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static DepartmentServices getInstance() {
		
		if(deptS == null)
			deptS = new DepartmentServicesImpl();
		return deptS;
	}
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		return deptR.addDepartment(department);
	}

	@Override
	public String updateDepartment(long id) {
		// TODO Auto-generated method stub
		return deptR.updateDepartment(id);
	}

	@Override
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		return deptR.deleteDepartment(id);
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return deptR.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return deptR.getDepartments();
	}

	@Override
	public Optional<List<Department>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		return deptR.findByOragnizationId(id);
	}

}
