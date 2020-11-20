package com.tcs.employeeManagement.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
		@Id
		private Long id;
		//private Long organizationId;
		//private Long departmentId;
		private String name;
		private int age;
		private String position;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "dept_id")
		private Department department;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "orgnaization_id")
		private Organization organization;
}
