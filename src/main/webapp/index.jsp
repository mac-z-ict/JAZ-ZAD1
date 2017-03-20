<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<title>Wyliczanie rat kredytu</title>
</head>
<body>
<h1>Wyliczanie rat kredytu</h1>
<form action="/installments" method="post">
<table border=1>
<tr><td>Wnioskowana kwota(1.00-1000000.00):</td><td><input type="text" id="kwota" name="kwota"/></td></tr>
<tr><td>Ilość rat(1-360):</td><td><input type="text" id="ilosc" name="ilosc"/></td></tr>
<tr><td>Oprocentowanie (0.01-100.00):</td><td><input type="text" id="procent" name="procent"/></td></tr>
<tr><td>Opłata stała(0.00-1000.00):</td><td><input type="text" id="oplata" name="oplata"/></td></tr>
<tr><td>Rodzaj rat:</td><td><select name="rodzaj" id="rodzaj">
<option value="0">--Wybierz typ rat--</option>
<option value="1">Stałe</option>
<option value="2">Malejące</option>
</select></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2"><center><input type="submit" value="WyŚlij"></center></td></tr>
</table>
</form>
</body>
</html>
