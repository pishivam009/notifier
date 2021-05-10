<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Remind Me App</title>
</head>
<body>
<h1 align="center">Remind Me</h1>
<form name="login-form" id="login-form" action="login" method="get">
	<label for="loginemail">Email ID</label>
	<br><input id="loginemail" name="loginemail" placeholder="Enter Email ID" autofocus="true" required="true" type="email"/>
	<br><label for="loginpassword">Password</label>
	<br><input id="loginpassword" name="loginpassword" placeholder="Enter Login Password" required="true" type="password"/>
	<br>
	<input type="submit" value="Login" form="login-form" id="loginsubmit"/>
</form>
Not a member? <a href="NewUser">Sign up</a>
</body>
</html>