package com.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbactions.ValidateUser;

/**
 * Servlet implementation class login
 */
public class loginservice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginservice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);

		ValidateUser va = new ValidateUser(username, password);
		if (va.checckusername() && va.checkpassword()) {
			// redirect to next login page
	 
			//response.sendRedirect("http://localhost:8081/LoginLogoutDemoUsingServlet/homepage.jsp");
			request.getRequestDispatcher("/homepage.jsp").forward(request,response);
			
		} else {
			if(!va.checckusername())
			{
				String message = "uername is not valid";
				
				request.setAttribute("message", message);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			if(!va.checkpassword()) {
				String message = "password is not valid";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				//response.sendRedirect("login.jsp");
			}
			// throw the error message
		}

	}

}
