<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/Práctica_de_laboratorioSERVELETSJDBC/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<title>Agenda Telefonica</title>
</head>
<body>
	<c:set var="usuario" value="${requestScope['usuario']}" />
	<h1>Usuario: ${usuario.nombre} ${usuario.apellido} #Cedula:
		${usuario.cedula}</h1>
		<form action="registroTelefonos" method="post"
		name="formularioTelefonos">
		<input type="hidden" value="${usuario.cedula}" name="usu_cedula" >
		<div class="input-group input-group-lg">
			<label for="numero">Numero:</label> 
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
	<div class="container" style="margin-top: 25px; padding: 10px">
		<h1>Lista Telefonos</h1>
		<hr>
		<a href="http://localhost:8080/Práctica_de_laboratorioSERVELETSJDBC/Agregar.jsp?usu_cedula=${usuario.cedula}" class="btn btn-success btn-lg">Nuevo Telefono</a>
		<table class="table table-bordered">
			<tr>
				<td class="text-center">NUMERO</td>
				<td class="text-center">TIPO</td>
				<td class="text-center">OPERADORA</td>
				<td colspan=2>ACCIONES<dth>
			</tr>
				<c:forEach var="telefonos" items="${usuario.telefonos}">
					<tr>
						<td><c:out value="${telefonos.numero}"/></td>
						<td><c:out value="${telefonos.tipo}"/></td>
						<td><c:out value="${telefonos.operadora}"/></td>
						<td class="text-center"><a class="btn btn-warning btn-sm"
							href="http://localhost:8080/Práctica_de_laboratorioSERVELETSJDBC/BuscarTelefono?codigo=${telefonos.codigo}">Modificar</a>

							<a class="btn btn-danger btn-sm"
							href="http://localhost:8080/Práctica_de_laboratorioSERVELETSJDBC/EliminarTelefono?codigo=${telefonos.codigo}">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<a href="http://localhost:8080/Práctica_de_laboratorioSERVELETSJDBC/CerrarSesion">Cerrar Sesion</a>
</body>
</html>