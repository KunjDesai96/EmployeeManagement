package com.tcs.employeeManagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	private Long id;
	private Long organizationId;
	private String name;
	//private List<Employee> employees;
}
