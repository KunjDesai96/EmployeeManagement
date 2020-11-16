package com.tcs.employeeManagement.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeManagement.model.Organization;

public interface OrganizationRepository {
	public String addOrganization(Organization organization);
	public String updateOrganization(long id);
	public String deleteOrganization(long id);
	public Optional<Organization> findById(long id);
	public Optional<List<Organization>> getOrganizations();
}
