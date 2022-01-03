<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Löydä tekemistä</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body style="padding:10px">
	<h1 style="text-align:center">Lista kaikista sivun tekemisistä</h1><br>
	<form action="/etusivu" style="text-align:center">
		<input type="submit" value="Etusivulle"/>
	</form><br><br>
	<table class="table table_striped">
		<tr>
			<th>Nimi</th>
			<th>Kuvaus</th>
			<th>Sijainti</th>
		</tr>
		<c:forEach items="${tekemiset}" var="tekeminen">
		<tr>
			<td>
				<c:out value="${tekeminen.nimi}" />
			</td>
			<td>
				<c:out value="${tekeminen.kuvaus}" />
			</td>
			<td>
				<c:out value="${tekeminen.sijainti}" />
			</td>
			<td>
				<a href="/poista_tekeminen?id=<c:out value="${tekeminen.id}"/>">Poista</a>
			</td>
			<td>
				<a href="/muokkaa_tekemiset?id=<c:out value="${tekeminen.id}"/>">Muokkaa</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>