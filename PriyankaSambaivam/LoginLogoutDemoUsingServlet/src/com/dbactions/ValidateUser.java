package com.dbactions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValidateUser {

	String username = "";
	String password = "";

	public ValidateUser(String name, String pwd) {
		username = name;
		password = pwd;
	}

	public boolean checckusername() {
		// going to check the username present in db or not
		DBConnection db = new DBConnection();
		Connection con = db.createDBConnection();
		ResultSet result = null;
		boolean userExist = false;
		String query = "select count(*) from users where username = '" + username + "';";
		Statement stmt;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(query);
			if (result != null && result.next() && result.getInt(1) >= 1) {
				userExist = true;
			} else {
				userExist = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return userExist;
		}
		return userExist;

	}

	public boolean checkpassword() {

		DBConnection db = new DBConnection();
		Connection con = db.createDBConnection();
		ResultSet result = null;
		boolean passwordExist = false;
		String query = "select count(*) from users where password = '" + password + "';";
		Statement stmt;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(query);
			if (result != null && result.next() && result.getInt(1) >= 1) {
				passwordExist = true;
			} else {
				passwordExist = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return passwordExist;
		}
		return passwordExist;

	}

}
