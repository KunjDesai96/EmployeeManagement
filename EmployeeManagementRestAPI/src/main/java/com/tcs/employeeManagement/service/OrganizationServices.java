package com.tcs.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeManagement.model.Organization;

public interface OrganizationServices {
	public Organization addOrganization(Organization organization);
	public void deleteOrganization(long id);
	public Optional<Organization> findById(long id);
	public Optional<List<Organization>> getOrganizations();
}
