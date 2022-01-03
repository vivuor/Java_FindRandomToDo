<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Virheilmoitus</title>
</head>
<body>
	<h1>Virheilmoitus</h1>
	<p><c:out value="${viesti}" /></p>
	<a href="/listaa_tekemiset">Tekemiset lista</a>
	<a href="/etusivu">Etusivulle</a>
</body>
</html>