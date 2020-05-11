<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrarme</title>
</head>
<body>
	<h1>Formulario de registro</h1>
	<form action="registrar" method="post">
	<label>Cedula</label>
	<input type="text" name="cedula"  required="true"/><br>
	<label>Nombre</label>
	<input type="text" name="nombre" required="true"/><br>
	<label>Apellido</label>
	<input type="text" name="apellido"  required="true"/><br>
	<label>Correo</label>
	<input type="text" name="correo"  required="true"/><br>
	<label>Contrasena</label>
	<input type="password" name="contrasena"  required="true"/><br>
	<input type="submit" value="Registrarme"/>
	</form>
</body>
</html>