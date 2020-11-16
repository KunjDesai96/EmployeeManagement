package com.tcs.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeManagement.dao.DepartmentRepository;
import com.tcs.employeeManagement.dao.DepartmentRepositoryImpl;
import com.tcs.employeeManagement.dao.OrganizationRepository;
import com.tcs.employeeManagement.dao.OrganizationRepostioryImpl;
import com.tcs.employeeManagement.model.Organization;

@Service
public class OrganizationServicesImpl implements OrganizationServices {

	@Autowired
	OrganizationRepository orgR;
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return orgR.addOrganization(organization);
	}

	@Override
	public String updateOrganization(long id) {
		// TODO Auto-generated method stub
		return orgR.updateOrganization(id);
	}

	@Override
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		return orgR.deleteOrganization(id);
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		return orgR.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return orgR.getOrganizations();
	}

}
