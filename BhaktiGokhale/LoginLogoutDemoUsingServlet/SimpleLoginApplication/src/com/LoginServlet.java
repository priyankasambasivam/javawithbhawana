package com;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
		Connection conn = null;
		ResultSet result = null;
		System.out.println("Inside LoginServlet");
		try {
			HttpSession session = request.getSession();
			if (username != null && password != null) {
				String dbUrl = "jdbc:mysql://localhost:3306/simplilearndb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root@123456";
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(dbUrl);
				String query = "select count(*) from users where username = '" + username + "' and password = '"
						+ password + "';";
				Statement stmt = conn.createStatement();
				result = stmt.executeQuery(query);
				if (result != null && result.next() && result.getInt(1) >= 1) {
					session.setAttribute("userObj", user);
					response.sendRedirect("logout.html");
				} else {
					session.setAttribute("error", "Invalid username/password");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
