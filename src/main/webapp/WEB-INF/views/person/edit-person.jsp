<%@page import="com.example.models.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Person</title>
</head>
<body>
	<h1>Edit Person</h1>
	<% Person person = (Person)request.getAttribute("person"); %>
	<form method="post" action="/person-java-web-app/person/edit">
		<input type="hidden" name="id" value="<%= person.getId() %>" />
		<label>Name:</label><input type="text" name="name" required="required" value="<%= person.getName() %>"><br />
		<label>Age:</label><input type="number" name="age" min="1" value="<%= person.getAge() %>"><br />
		<br />
		<input type="submit" value="Update">
	</form>
</body>
</html>
