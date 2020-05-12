<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Sesion</title>
<script type="text/javascript" src="js/main.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
		<div class="row text-center login-page">
			<div class="col-md-12 login-form">
				<form action="InicioSesion" method="post" id="forminicio"> 
					
					<div class="row">
						<div class="col-md-12 login-form-header">
							<p class="login-form-font-header">Iniciar<span>Sesion</span><p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 login-from-row">
							<input name="correo" id="txtcorreo" type="text" placeholder="Correo" required/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 login-from-row">
							<input name="contrasena" type="password" placeholder="Contraseña" required/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 login-from-row">
						 <input type="submit" value="Iniciar Sesion" class="btn btn-info" id="btninicio"/>
						</div>
					</div>
				</form>
				<br>
	No tienes una cuenta ...<a href="registro.jsp">Registarme</a>
			</div>
		</div>
	</div>
	 <footer>
            <div class="icon_footer">
                <i class="fas fa-chevron-up"></i>
            </div>
            <div class="social_foote">
                <a href="https://www.facebook.com/marco.orellana.796" target="_BLANK"><i class="fab fa-facebook-square"></i></a>
                <a href="https://github.com/MarkOrellana/Pr-ctica-de-laboratorio-01-Servlets-JSP-y-JDBC" target="_BLANK"><i class="fab fa-github-square"></i></a>
            </div>
            <p>&COPY; 2020 Todos los derechos reservados | Designed By Mark Orellana</p>
        </footer>

</body>
</html>
	