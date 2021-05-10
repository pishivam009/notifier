<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Form</title>
</head>
<body>
<h1>Remind Me</h1>
<h3>Create New User Account</h3>
	<form name="new-user-form" id="new-user-form" method="post" action="createNewUser">
		<label for="username">User Name</label><br>
		<input id="username" name="username" placeholder="Enter User Name" required="true" type="text"/><br>
		<label for="useremail">E-mail</label><br>
		<input id="useremail" name="useremail" placeholder="Enter User Email" required="true" type="email"/><br>
		<label for="password">Password</label><br>
		<input id="password" name="userpassword" placeholder="Enter Password" required="true" type="password"/><br>
		<label for="usercontact">Mobile Number</label><br>
		<input id="usercontact" name="usercontact" placeholder="Enter Mobile Number" maxlength="10" required="true" type="number"/><br>
		<input type="submit" value="Create New Account" form="new-user-form" id="button-1" formmethod="post"/>
	</form>
</body>
</html>