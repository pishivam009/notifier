<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	${user.name} 
<a href="showNotebooks">Show Notebooks</a>
<a href="newNotebook">New Notebook</a>
<a href="editUser">Edit User Details</a>
<a href="logout">Logout</a>
<c:forEach items = "${list}" var = "nb">
		<a href="openNotebook/${nb.nbid}"/>${nb.nbname}</a>
         <a href="editNotebook/${nb.nbid}"/>Edit</a>
         <a href="deleteNotebook/${nb.nbid}"/>Delete</a>
      </c:forEach>
</body>
</html>