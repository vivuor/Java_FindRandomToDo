<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>L�ysit tekemist�</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body style="padding:10px">
	<h1 style="text-align:center">L�ysit tekemist�!</h1>
	<p style="text-align:center">T�ss� sinulle tekemist� t�lle p�iv�lle. Jos olet k�ynyt jo kohteessa paina "Hae uudelleen" nappulaa</p>
	<form action="/etusivu" style="text-align:center">
		<input type="submit" value="Etusivulle" />
	</form><br>
	<form action="/hae_tekeminen" style="text-align:center">
		<input type="submit" value="Hae uudelleen"/>
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
			<c:out value="${tekeminen.nimi}"/>
			</td>
			<td>
			<c:out value="${tekeminen.kuvaus}"/>
			</td>
			<td>
			<c:out value="${tekeminen.sijainti}"/>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>