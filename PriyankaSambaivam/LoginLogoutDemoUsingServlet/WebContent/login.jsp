<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Project</title>
</head>
<body>
	<form action="loginservice" method="post">
		<br /> 
		<br /> 
		<label for="username">Username: </label> 
		<input type="text" name="username" placeholder="username" /> 
		<br />
		<br /> 
		<label for="password">Password: </label> 
		<input type="password" name="password" placeholder="password" /> 
		<br />
		<br /> 
		<input type="submit" value="Login" />
		 <p>Message: ${message}</p>
	</form>
</body>
</html>