package com.tcs.employeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.employeeManagement.model.Department;
import com.tcs.employeeManagement.model.Organization;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer>{
	public Optional<Organization> findById(long id);
}
