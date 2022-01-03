<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa tietoja</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
	<h1>Muokkaa tämän tekemisen tietoja</h1><br><br>
		<form action="/muokkaa_tekemiset" method="post">
			<label for="id">Id:</label><br>
			<input type="text" id="id" name="id" value="<c:out value="${tekeminen.id}"/>" required><br>
			<label for="nimi">Nimi:</label><br>
			<input type="text" id="nimi" name="nimi" value="<c:out value="${tekeminen.nimi}"/>" required><br><br>
			<label for="kuvaus">Mitä tekemistä paikassa on:</label><br>
			<input type="text" id="kuvaus" name="kuvaus" size="150" value="<c:out value="${tekeminen.kuvaus}"/>" required><br><br>
			<label for="sijainti">Missä paikka sijaitsee:</label><br>
			<input type="text" id="sijainti" name="sijainti" value="<c:out value="${tekeminen.sijainti}"/>" required><br><br>
			<input type="submit" value="Tallenna">
		</form>
</body>
</html>