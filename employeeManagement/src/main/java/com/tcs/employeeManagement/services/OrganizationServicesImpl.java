package com.tcs.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tcs.employeeManagement.repository.OrganizationRepository;
import com.tcs.employeeManagement.model.Organization;

@Service
public class OrganizationServicesImpl implements OrganizationServices {

	@Autowired
	OrganizationRepository orgR;
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		try {
			orgR.save(organization);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Failure";		
	}

	@Override
	public String updateOrganization(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return null;
	}

}
