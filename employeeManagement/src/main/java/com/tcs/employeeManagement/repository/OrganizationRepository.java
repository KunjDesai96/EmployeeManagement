package com.tcs.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.employeeManagement.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
