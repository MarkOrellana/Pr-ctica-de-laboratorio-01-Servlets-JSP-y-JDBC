<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Sesion</title>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<h1>Iniciar Sesion</h1>
<form action="InicioSesion" method="post" id="forminicio">
<label>Correo</label>
<input type="text" name="correo" id="txtcorreo"/><br> 
<label>Contrasena</label>
<input type="password" name="contrasena" id="txtcontra"/><br>
<input type="submit" value="Iniciar Sesion" id="btninicio"/>
</form>
<br>
	No tienes una cuenta ...<a href="registro.jsp">Registarme</a>
</body>
</html>