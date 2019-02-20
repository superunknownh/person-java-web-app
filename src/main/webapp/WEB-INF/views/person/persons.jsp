<%@page import="com.example.models.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Persons</title>
</head>
<body>
	<h1>Persons</h1>
	<form method="get" action="/person-java-web-app/person/new">
		<input type="submit" value="New Person" />
	</form>
	<br />
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Options</th>
		</tr>
		<% Person[] persons = (Person[])request.getAttribute("persons"); %>
		<% for (Person person : persons) { %>
			<tr>
				<td><%= person.getId() %>
				<td><%= person.getName() %></td>
				<td><%= person.getAge() %>
				<td>
					<a href="person/edit?id=<%= person.getId() %>">edit</a>
					<a href="#" onclick="deletePerson('<%= person.getId() %>')">delete</a>
				</td>
			</tr>
		<% } %>
	</table>
</body>

<script type="text/javascript">
	const deletePerson = (id) => {
		const deleteConfirm = confirm("Are you sure to delete the id " + id + "?");
		if (deleteConfirm) {
			window.location.href = "person/delete?id=" + id	
		}
	}
</script>

</html>
