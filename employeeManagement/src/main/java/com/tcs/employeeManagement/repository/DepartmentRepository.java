package com.tcs.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.employeeManagement.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
