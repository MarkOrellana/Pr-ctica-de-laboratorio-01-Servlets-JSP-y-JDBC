<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/Práctica_de_laboratorioSERVELETSJDBC/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<title>Agregar Telefono</title>
</head>
<body>
<c:set var="usuario" value="${requestScope['usuario']}"/>
<form action="registroTelefonos" method="post"
		name="formularioTelefonos">
		<input type="hidden" value="${usuario.usu_cedula}" name="usu_cedula" >
		<div class="input-group input-group-lg">
			<label for="numero">Numero:</label> <span class="input-group-addon"
				id="sizing-addon1"><i class="glyphicon glyphicon-envelope"></i></span>
			<input type="text" class="form-control" name="numero"
				placeholder="Numero" id="txtnumero" aria-describedby="sizing-addon1"
				required>
		</div>
		<br>

		<div id="selectorTipo">
			<label for="tipo">Tipo: </label> <select id="txttipo" name="tipo">
				<option value="movil">Movil</option>
				<option value="fijo">Convencional</option>
			</select>
		</div>
		<br>

		<div id="selectorOperadora">
			<label for="operadora">Operadora: </label> <select id="txtoperadora"
				name="operadora">
				<option value="tuenti">Tuenti</option>
				<option value="claro">Claro</option>
				<option value="cnt">Cnt</option>
				<option value="movistar">Movistar</option>
			</select>
		</div>
		<br> <br>


		<button class="btn btn-primary btn-lg"
			id="Registrarce" type="submit">Registrar</button>
			</form>
</body>
</html>