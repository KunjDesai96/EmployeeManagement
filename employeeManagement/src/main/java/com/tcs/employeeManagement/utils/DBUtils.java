package com.tcs.employeeManagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {
	
	@Autowired
	DataSource ds;
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
