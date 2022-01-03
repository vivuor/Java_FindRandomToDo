<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>L�yd� tekemist�</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body style="padding:10px">
	<h1 style= "text-align:center">Tervetuloa random tekemist� generaattoriin</h1>
	<p style= "text-align:center">T�ll� sivulla voit hakea k�ytt�jien lis��mi� tekemisi� Helsingiss�. Sivun tarkoituksena on auttaa juuri sinua l�yt�m��n jotain tekemist�,
	kun et keksi mit� tekisit</p><br>
	<h2>Hae tekemist�</h2>
	<form action="/hae_tekeminen"><br>
		<input type="submit" value="Hae tekemist�"/>
	</form><br>
	<h2>N�yt� lista kaikista tekemisist�</h2>
	<form action="/listaa_tekemiset"><br>
		<input type="submit" value="Kaikki tekemiset"/>
	</form><br>
	<h2>Lis�� uusi tekeminen</h2>
	<form action="/etusivu" method="post">
		<label for="nimi">Nimi:</label><br>
		<input type="text" id="nimi" name="nimi" required><br><br>
		<label for="kuvaus" method="post">Mit� tekemist� paikassa on:</label><br>
		<textarea rows="10" cols="50" type="text" id="kuvaus" name="kuvaus" required></textarea><br><br>
		<label for="sijainti">Miss� paikka sijaitsee:</label><br>
		<input type="text" id="sijainti" name="sijainti" required><br><br>
		<input type="submit" value="Tallenna">
		<input type="reset" value="Peruuta">
	</form>
</body>
</html>