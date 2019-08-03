<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="LoginServlet" method="post">
	<% 
	String error = (String)request.getAttribute("error");
	String message = (String)request.getAttribute("message");
	if (error != null) { %>
		<%=error%>
	<% } if (message != null) { %>
		<%=message%>
	<% } %>
	<br/>
	<input type="text" name="username" placeholder="Enter username"/> <br/>
	<input type="password" name="password" placeholder="Enter password"/>
	<input type="submit" value="Login"/>
	</form>
</body>
</html>