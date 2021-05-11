<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${user.email}
	<form name="new-notebook-form" id="new-notebook-form" action="createNotebook" method="post">
		<label for="nbname">Notebook Name</label>
		<input id="nbname" name="nbname" placeholder="Enter Notebook Name" required="true" type="text"/>
		<input type="submit" value="Create" form="new-notebook-form" id="button-1" formmethod="post"/>
	</form>
</body>
</html>