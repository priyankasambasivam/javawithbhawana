<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% User userObj = (User)session.getAttribute("userObj");
	String username = null;
	if (userObj != null) {
	 username = userObj.getUsername();
	}
%>
<h1>Welcome <%= (username != null) ? username: ""%> ! </h1>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout"/>
	</form>
</body>
</html>