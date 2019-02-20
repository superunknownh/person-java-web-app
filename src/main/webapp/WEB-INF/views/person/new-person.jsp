<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Person</title>
</head>
<body>
	<h1>New Person</h1>
	<form method="post" action="/person-java-web-app/person/new">
		<label>Name:</label><input type="text" name="name" required="required"><br />
		<label>Age:</label><input type="number" name="age" min="1"><br />
		<br />
		<input type="submit" value="Save">
	</form>
</body>
</html>
