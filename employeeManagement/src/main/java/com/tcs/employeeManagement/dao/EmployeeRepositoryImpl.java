package com.tcs.employeeManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tcs.employeeManagement.model.Employee;
import com.tcs.employeeManagement.utils.DBUtils;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	DBUtils dbUtils;
	@Override
	public String addEmployeee(Employee employee) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		int res =  0;
		String sql = "insert into employee (id, organizationId, departmentId, name, age, position) values (?,?,?,?,?,?)";
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setLong(1, employee.getId());
			//pStmt.setLong(2, employee.getOrganizationId());
			//pStmt.setLong(3, employee.getDepartmentId());
			pStmt.setString(4, employee.getName());
			pStmt.setInt(5, employee.getAge());
			pStmt.setString(6, employee.getPosition());
			res = pStmt.executeUpdate();
			if(res > 0)
			{
				con.commit();
				return "Success";
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally
		{
			dbUtils.closeConnection(con);
		}
		return "Failure";
	}

	@Override
	public String updateEmployee(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> empO = findById(id);
		
		if(empO.isPresent())
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Enter organization id: ");
			long orgId = s.nextLong();
			System.out.println("Enter department id: ");
			long deptId = s.nextLong();
			System.out.println("Enter name: ");
			String name = s.next();
			System.out.println("Enter age: ");
			int age = s.nextInt();
			System.out.println("Enter position: ");
			String position = s.next();
			Connection con = dbUtils.getConnection();
			PreparedStatement pStmt = null;
			int res =  0;
			String sql = "update employee set organizationId = ?,departmentId = ?, name = ?, age = ?, position = ? where Id= ?";
			try {
				pStmt = con.prepareStatement(sql);
				pStmt.setLong(1,orgId);
				pStmt.setLong(2, deptId);
				pStmt.setString(3, name);
				pStmt.setInt(4,age);
				pStmt.setString(5, position);
				pStmt.setLong(6,id);
				res = pStmt.executeUpdate();
				if(res > 0)
				{
					con.commit();
					return "Success";
				}	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					con.rollback();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			} finally
			{
				dbUtils.closeConnection(con);
			}
		}
		return "Failure";
	}

	@Override
	public String deleteEmployee(long id) {
		Optional<Employee> emp = findById(id);
		if(emp.isPresent())
		{
			Connection con = dbUtils.getConnection();
			Statement stmt = null;
			String sql = "delete from employee where id = "+id;
			int res = 0;
			
			try {
				stmt = con.createStatement();
				res = stmt.executeUpdate(sql);
				if(res > 0)
				{
					con.commit();
					return "Success";
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return "Failure";
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from employee where id = ?";
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setLong(1, id);
			rs = pStmt.executeQuery();
			if(rs.next())
			{
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				//emp.setOrganizationId(rs.getLong("organizationId"));
				//emp.setDepartmentId(rs.getLong("departmentId"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setPosition(rs.getString("position"));
				return Optional.of(emp);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally
		{
			dbUtils.closeConnection(con);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from employee";
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			List<Employee> empL = new ArrayList<>();
			while(rs.next())
			{
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				//emp.setOrganizationId(rs.getLong("organizationId"));
				//emp.setDepartmentId(rs.getLong("departmentId"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setPosition(rs.getString("position"));
				empL.add(emp);
			}
			return Optional.of(empL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally
		{
			dbUtils.closeConnection(con);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Employee>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from employee where organizationId = "+id;
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			List<Employee> empL = new ArrayList<>();
			while(rs.next())
			{
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				//emp.setOrganizationId(rs.getLong("organizationId"));
				//emp.setDepartmentId(rs.getLong("departmentId"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setPosition(rs.getString("position"));
				empL.add(emp);
			}
			return Optional.of(empL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally
		{
			dbUtils.closeConnection(con);
		}
		return Optional.empty();
	}
	@Override
	public List<Employee> findByDepartmentById(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from employee where departmentId = "+id;
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			List<Employee> empL = new ArrayList<>();
			while(rs.next())
			{
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				//emp.setOrganizationId(rs.getLong("organizationId"));
				//emp.setDepartmentId(rs.getLong("departmentId"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setPosition(rs.getString("position"));
				empL.add(emp);
			}
			return empL;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally
		{
			dbUtils.closeConnection(con);
		}
		return null;
	}

}
