<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Löydä tekemistä</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body style="padding:10px">
	<h1 style= "text-align:center">Tervetuloa random tekemistä generaattoriin</h1>
	<p style= "text-align:center">Tällä sivulla voit hakea käyttäjien lisäämiä tekemisiä Helsingissä. Sivun tarkoituksena on auttaa juuri sinua löytämään jotain tekemistä,
	kun et keksi mitä tekisit</p><br>
	<h2>Hae tekemistä</h2>
	<form action="/hae_tekeminen"><br>
		<input type="submit" value="Hae tekemistä"/>
	</form><br>
	<h2>Näytä lista kaikista tekemisistä</h2>
	<form action="/listaa_tekemiset"><br>
		<input type="submit" value="Kaikki tekemiset"/>
	</form><br>
	<h2>Lisää uusi tekeminen</h2>
	<form action="/etusivu" method="post">
		<label for="nimi">Nimi:</label><br>
		<input type="text" id="nimi" name="nimi" required><br><br>
		<label for="kuvaus" method="post">Mitä tekemistä paikassa on:</label><br>
		<textarea rows="10" cols="50" type="text" id="kuvaus" name="kuvaus" required></textarea><br><br>
		<label for="sijainti">Missä paikka sijaitsee:</label><br>
		<input type="text" id="sijainti" name="sijainti" required><br><br>
		<input type="submit" value="Tallenna">
		<input type="reset" value="Peruuta">
	</form>
</body>
</html>