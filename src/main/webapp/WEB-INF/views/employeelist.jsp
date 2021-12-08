<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>

	<div align="center">
		<h1>Employee list</h1>
	</div>

	<div align="center">
		<table border="2" width="70%" cellpadding="2" align="center">
			<tr>
				<th>Name</th>
				<th>ProjectDetails</th>
				<th>Mail Id</th>
				<th>phone number</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${employeeList}" var="emp">
				<tr align="center">
					<td>${emp.name}</td>
					<td>${emp.project}</td>
					<td>${emp.mailId}</td>
					<td>${emp.phoneNo}</td>
					<td><a href="updateEmployee?employeeId=${emp.employeeId}">edit</a>
					<td><a href="deleteEmployee/${emp.employeeId}">delete</a>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>