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

import com.tcs.employeeManagement.model.Department;
import com.tcs.employeeManagement.model.Employee;
import com.tcs.employeeManagement.utils.DBUtils;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
	@Autowired
	DBUtils dbUtils;
	@Autowired
	EmployeeRepository empR;
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		int res =  0;
		String sql = "insert into department (id, organizationId, name) values (?,?,?)";
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setLong(1, department.getId());
			pStmt.setLong(2, department.getOrganizationId());		
			pStmt.setString(3, department.getName());
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
	public String updateDepartment(long id) {
		// TODO Auto-generated method stub
		Optional<Department> deptO = findById(id);
		if(deptO.isPresent())
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Enter organization id: ");
			long orgId = s.nextLong();
			System.out.println("Enter name: ");
			String name = s.next();
			Connection con = dbUtils.getConnection();
			PreparedStatement pStmt = null;
			int res =  0;
			String sql = "update department set organizationId = ?, name = ? where Id= ?";
			try {
				pStmt = con.prepareStatement(sql);
				pStmt.setLong(1,orgId);
				pStmt.setString(2, name);
				pStmt.setLong(3,id);
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
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		Optional<Department>  dept = findById(id);
		if(dept.isPresent())
		{
			Connection con = dbUtils.getConnection();
			Statement stmt = null;
			String sql = "delete from department where id = "+id;
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
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from department where id = ?";
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setLong(1, id);
			rs = pStmt.executeQuery();
			if(rs.next())
			{
				Department dept = new Department();
				dept.setId(rs.getLong("id"));
				dept.setOrganizationId(rs.getLong("organizationId"));
				dept.setName(rs.getString("name"));
				dept.setEmployees(empR.findByDepartmentById(id));
				return Optional.of(dept);
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
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from department";
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			List<Department> deptL = new ArrayList<>();
			while(rs.next())
			{
				Department dept = new Department();
				dept.setId(rs.getLong("id"));
				dept.setOrganizationId(rs.getLong("organizationId"));
				dept.setName(rs.getString("name"));
				dept.setEmployees(findById(dept.getId()).get().getEmployees());
				deptL.add(dept);
			}
			return Optional.of(deptL);
			
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
	public Optional<List<Department>> findByOragnizationId(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from department where organizationId = "+id;
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			List<Department> deptL = new ArrayList<>();
			while(rs.next())
			{
				Department dept = new Department();
				dept.setId(rs.getLong("id"));
				dept.setOrganizationId(rs.getLong("organizationId"));
				dept.setName(rs.getString("name"));
				dept.setEmployees(findById(dept.getId()).get().getEmployees());
				deptL.add(dept);
			}
			return Optional.of(deptL);
			
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

}
