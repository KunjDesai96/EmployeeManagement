package com.tcs.employeeManagement.services;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeManagement.model.Organization;

public interface OrganizationServices {
	public String addOrganization(Organization organization);
	public String updateOrganization(long id);
	public String deleteOrganization(long id);
	public Optional<Organization> findById(long id);
	public Optional<List<Organization>> getOrganizations();
}
