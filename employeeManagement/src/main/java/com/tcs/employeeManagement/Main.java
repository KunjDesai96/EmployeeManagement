package com.tcs.employeeManagement;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employeeManagement.config.DBConfig;
import com.tcs.employeeManagement.model.Department;
import com.tcs.employeeManagement.model.Employee;
import com.tcs.employeeManagement.model.Organization;
import com.tcs.employeeManagement.services.DepartmentServices;
import com.tcs.employeeManagement.services.EmployeeServices;
import com.tcs.employeeManagement.services.OrganizationServices;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		EmployeeServices empS = context.getBean(EmployeeServices.class);
		DepartmentServices deptS = context.getBean(DepartmentServices.class);
		OrganizationServices orgS = context.getBean(OrganizationServices.class);
		
		char ch = 'Y';
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Employee");
			System.out.println("2. Department");
			System.out.println("3. Organization");
			System.out.println("Please choose to edit: ");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("1. Add new employee.");
				System.out.println("2. Update employee.");
				System.out.println("3. Delete employee.");
				System.out.println("4. Find employee by Id.");
				System.out.println("5. Get all employees.");
				System.out.println("6. Find employee/s by organization Id.");
				System.out.println("Please choose one of the following options:");

				int option = sc.nextInt();

				switch (option) {
				case 1:
					System.out.println("Enter employee id");
					long empId = sc.nextLong();
					System.out.println("Enter organization id:");
					long orgId = sc.nextLong();
					System.out.println("Enter department id: ");
					long deptId = sc.nextLong();
					System.out.println("Enter employee name: ");
					String name = sc.next();
					System.out.println("Enter employee age: ");
					int age = sc.nextInt();
					System.out.println("Enter employee position: ");
					String position = sc.next();
					Employee employee = new Employee(empId, name, age, position, deptS.findById(deptId).get(),orgS.findById(orgId).get());
					if(empS.addEmployeee(employee).equals("Success"))
						System.out.println("Employee added successfully");
					else
						System.out.println("Fail");
					break;
				case 2:
					long id = 0;
					System.out.println("Enter the employee id: ");
					id = sc.nextLong();
					if((empS.updateEmployee(id)).equals("Success"))
							System.out.println("Employee updated successfully");
					else
						System.out.println("Fail");
					break;
				case 3:
					long id1 = 0;
					System.out.println("Enter the employee id: ");
					id1 = sc.nextLong();
					if((empS.deleteEmployee(id1)).equals("Success"))
						System.out.println("Employee deleted successfully");
					else
						System.out.println("Fail");
					break;
				case 4:
					long id2 = 0;
					System.out.println("Enter the employee id: ");
					id2 = sc.nextLong();
					Optional<Employee> empO = empS.findById(id2);					
					if(empO.isPresent())	
						System.out.println(empO.get());
					else	
						System.out.println("No employee found.");
					break;
				case 5:
					Optional<List<Employee>> empL =  empS.getEmployees();
					if(empL.isPresent())
						System.out.println(empL.get());
					else	
						System.out.println("No employee found.");
					break;
				case 6:
					long id3 = 0;
					System.out.println("Enter the organization id: ");
					id3 = sc.nextLong();
					Optional<List<Employee>> empOL =  empS.findByOragnizationId(id3);
					if(empOL.isPresent())
						System.out.println(empOL.get());
					else	
						System.out.println("No employee found.");
					break;
				default:
					System.out.println("Please  enter correct option:");
					break;
				}
				break;
			case 2:
				System.out.println("1. Add new department.");
				System.out.println("2. Update department.");
				System.out.println("3. Delete department.");
				System.out.println("4. Find department by Id.");
				System.out.println("5. Get all department.");
				System.out.println("6. Find department/s by organization Id.");
				System.out.println("Please choose one of the following options:");

				int option1 = sc.nextInt();

				switch (option1) {
				case 1:

					System.out.println("Enter department id");
					long deptId = sc.nextLong();
					System.out.println("Enter organization id:");
					long orgId = sc.nextLong();
					System.out.println("Enter department name: ");
					String name = sc.next();					
					if ((deptS.addDepartment(new Department(deptId, orgId, name,null)).equals("Success")))
							System.out.println("Department created succesfully");
					break;
				case 2:
					long id = 0;
					System.out.println("Enter the Department id: ");
					id = sc.nextLong();
					deptS.updateDepartment(id);
					break;
				case 3:
					long id1 = 0;
					System.out.println("Enter the Department id: ");
					id1 = sc.nextLong();
					deptS.deleteDepartment(id1);
					break;
				case 4:
					long id2 = 0;
					System.out.println("Enter the Department id: ");
					id2 = sc.nextLong();
					Optional<Department> dept = deptS.findById(id2);
					if(dept.isPresent())
						System.out.println(dept);
					else
						System.out.println("No departments found");
					break;
				case 5:
					if(deptS.getDepartments().isPresent())
						System.out.println(deptS.getDepartments());
					else
						System.out.println("No departments found");
					break;
				case 6:
					long id3 = 0;
					System.out.println("Enter the organization id: ");
					id3 = sc.nextLong();
					Optional<List<Department>> deptL = deptS.findByOragnizationId(id3);
					if(deptL.isPresent())
						System.out.println(deptL.get());
					else
						System.out.println("No department found");
					break;
				default:
					System.out.println("Please  enter correct option.");
					break;
				}
				break;
			case 3:
				System.out.println("1. Add new organization.");
				System.out.println("2. Update organization.");
				System.out.println("3. Delete organization.");
				System.out.println("4. Find organization by Id.");
				System.out.println("5. Get all organization.");
				System.out.println("Please choose one of the following options:");

				int option2 = sc.nextInt();

				switch (option2) {
				case 1:

					System.out.println("Enter organization id");
					long orgId = sc.nextLong();
					System.out.println("Enter organization name: ");
					String name = sc.next();
					System.out.println("Enter organization address: ");
					String address = sc.next();
					if((orgS.addOrganization(new Organization(orgId, name, address,null)).equals("Success")))
							System.out.println("Organization created successfully");
					break;
				case 2:
					long id = 0;
					System.out.println("Enter the organization id: ");
					id = sc.nextLong();
					if((orgS.updateOrganization(id)).equals("Success"))
							System.out.println("Organization update successful.");
					else
						System.out.println("Failure");
					break;
				case 3:
					long id1 = 0;
					System.out.println("Enter the organization id: ");
					id1 = sc.nextLong();
					if((orgS.deleteOrganization(id1)).equals("Success"))
						System.out.println("Organization update successful.");
					else
						System.out.println("Failure");
					break;
				case 4:
					long id2 = 0;
					System.out.println("Enter the organization id: ");
					id2 = sc.nextLong();
					Optional<Organization> org = orgS.findById(id2);
					if(org.isPresent())
						System.out.println(org.get());
					else
						System.out.println("No organization found");
					break;
				case 5:
					Optional<List<Organization>> orgL = orgS.getOrganizations();
					if(orgL.isPresent())
						System.out.println(orgL.get());
					else
						System.out.println("No organization found");
					break;
				default:
					System.out.println("Please  enter correct option.");
					break;
				}
				break;
				default:
					System.out.println("Please enter corrent option.");
					break;
			}
			System.out.println("If you want to continue please enter 'Y'.");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch== 'y');
		System.out.println("Exit.");
		context.close();
	}
}
