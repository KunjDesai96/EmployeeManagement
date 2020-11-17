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
import com.tcs.employeeManagement.model.Organization;
import com.tcs.employeeManagement.utils.DBUtils;

@Repository
public class OrganizationRepostioryImpl implements OrganizationRepository {
	@Autowired
	DBUtils dbUtils; 
	@Autowired
	EmployeeRepository empR;
	@Autowired
	DepartmentRepository deptR;
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		int res =  0;
		String sql = "insert into organization (id, name, address) values (?,?,?)";
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setLong(1, organization.getId());
			pStmt.setString(2, organization.getName());		
			pStmt.setString(3, organization.getAddress());
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
	public String updateOrganization(long id) {
		// TODO Auto-generated method stub
		Optional<Organization>  org = findById(id);
		if(org.isPresent())
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Enter name: ");
			String name = s.next();
			System.out.println("Enter address: ");
			String address = s.next();
			Connection con = dbUtils.getConnection();
			PreparedStatement pStmt = null;
			int res =  0;
			String sql = "update organization set name = ?, address = ? where Id= ?";
			try {
				pStmt = con.prepareStatement(sql);
				pStmt.setString(1,name);
				pStmt.setString(2, address);
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
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		Optional<Organization>  org = findById(id);
		if(org.isPresent())
		{
			Connection con = dbUtils.getConnection();
			Statement stmt = null;
			String sql = "delete from organization where id = "+id;
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
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from organization where id = ?";
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setLong(1, id);
			rs = pStmt.executeQuery();
			if(rs.next())
			{
				Organization org = new Organization();
				org.setId(rs.getLong("id"));
				org.setName(rs.getString("name"));
				org.setAddress(rs.getString("address"));
			//	org.setEmployees(empR.findByOragnizationId(id).get());
				//org.setDepartments(deptR.findByOragnizationId(id).get());
				return Optional.of(org);
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
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		Connection con = dbUtils.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select * from organization";
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			List<Organization> orgL = new ArrayList<>();
			while(rs.next())
			{
				Organization org = new Organization();
				org.setId(rs.getLong("id"));
				org.setName(rs.getString("name"));
				org.setAddress(rs.getString("address"));
				//org.setEmployees(empR.findByOragnizationId(org.getId()).get());
				//org.setDepartments(deptR.findByOragnizationId(org.getId()).get());
				orgL.add(org);
			}
			return Optional.of(orgL);
			
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
