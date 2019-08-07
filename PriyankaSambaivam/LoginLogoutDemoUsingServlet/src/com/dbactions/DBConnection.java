package com.dbactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public Connection createDBConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/simplilearndb";
		Properties pro = new Properties();
		pro.put("user", "root");
		pro.put("password", "root");
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			con = DriverManager.getConnection(dbURL, pro);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			return con;
		}

		return con;

	}
}
