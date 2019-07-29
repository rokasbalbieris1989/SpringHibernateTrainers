<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Trainers</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Trainers</h2>	
	<table>
		<tr>
			<td>FIRST NAME</td><td>LAST NAME</td><td>Date Of Birth</td><td>Subject</td><td>Username</td><td></td>
		</tr>
		<c:forEach items="${trainers}" var="trainer">
			<tr>
                        
			<td>${trainer.first_name}</td>
                        <td>${trainer.last_name}</td>
			<td>${trainer.dateOfBirth}</td>
			<td>${trainer.subject}</td>
                        <td>${trainer.username}</td>
			<td><a href="<c:url value='/edit-${trainer.id}-trainer' />">${trainer.id}</a></td>
			<td><a href="<c:url value='/delete-${trainer.id}-trainer' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Trainer</a>
</body>
</html>