<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda Telefonica</title>
</head>
<body>
	<c:set var="usuario" value="${requestScope['usuario']}" />
	<h1>Usuario: ${usuario.nombre} ${usuario.apellido} con Cedula: ${usuario.cedula}</h1>

	<form action="registroTelefonos" method="post"
		name="formularioTelefonos">

		<input type="hidden" value="${usuario.cedula}" id="cedula"
			name="cod_cedula">
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


		<button class="btn btn-lg btn-primary btn-block btn-signin"
			id="Registrarce" type="submit">Registrar</button>

	</form>
	<div class="container" style="margin-top: 25px; padding: 10px">
		<table id="tablax" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<th>NUMERO</th>
				<th>TIPO</th>
				<th>OPERADORA</th>
				<th>ACCIONES</th>

			</thead>
			<tbody>
				<c:forEach var="telefonos" items="${usuario.telefonos}">
					<tr>
						<td>${telefonos.numero}</td>
						<td>${telefonos.tipo}</td>
						<td>${telefonos.operadora}</td>
						<td><a
							href="http://localhost:8080/Práctica_de_laboratorioSERVELETSJDBC/BuscarTelefono?id_tel=${telefonos.id_tel}">Modificar</a>

							<a
							href="http://localhost:8080/Práctica_de_laboratorioSERVELETSJDBC/EliminarTelefono?id_tel=${telefonos.id_tel}">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
        $(document).ready(function () {
            $('#tablax').DataTable({
                language: {
                    processing: "Tratamiento en curso...",
                    search: "Buscar&nbsp;:",
                    lengthMenu: "Agrupar de _MENU_ items",
                    info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
                    infoEmpty: "No existen datos.",
                    infoFiltered: "(filtrado de _MAX_ elementos en total)",
                    infoPostFix: "",
                    loadingRecords: "Cargando...",
                    zeroRecords: "No se encontraron datos con tu busqueda",
                    emptyTable: "No hay datos disponibles en la tabla.",
                    paginate: {
                        first: "Primero",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Ultimo"
                    },
                    aria: {
                        sortAscending: ": active para ordenar la columna en orden ascendente",
                        sortDescending: ": active para ordenar la columna en orden descendente"
                    }
                },
                scrollY: 400,
                lengthMenu: [ [10, 25, -1], [10, 25, "All"] ],
            });
        });
    </script>


</body>
</html>