package com.tcs.employeeManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

		@Id
		private Long id;
		private Long organizationId;
		private Long departmentId;
		private String name;
		private int age;
		private String position;
}
