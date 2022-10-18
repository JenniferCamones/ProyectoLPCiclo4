<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Spartan:wght@300;600&display=swap" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<body>
   <!-- <%
    String x =(String) request.getAttribute("msj");
    String a="";
    if(x!=null)
    	a=x;
   %> -->
	<div class="container-sm">
		<br>
		<h1 class="font-weight-bold mb-4 text-center"
			style="padding: 10px 5px 10px 5px; border-radius: 10px">¡
			Bienvenido !</h1>
		<div class="Formulario">
			<form action="ServletUsuario" name="frmsesion" method="post"
				class="mb-5 text-center items-align-center">
				<div class="mb-4">
					<label for="exampleInputEmail1" class="form-label font-weight-bold">Usuario</label>
					<center>
						<input type="text" name="txtUsuario" class="form-control"
							style="width: 350px" id="exampleInputEmail1"
							placeholder="Ingresa tu usuario" aria-describedby="emailHelp">
					</center>
				</div>
				<div class="mb-4">
					<label for="exampleInputPassword1"
						class="form-label font-weight-bold">Contraseña</label>
					<center>
						<input type="text" name="txtClave" class="form-control"
							style="width: 350px" placeholder="Ingresa tu contraseña"
							id="exampleInputPassword1">
					</center>
					<br> <a href="#" id="emailHelp"
						class="form-text text-muted text-decoration-none">¿Has
						olvidado tu contraseña?</a>
				</div>
				<div class="text-center">
					<button type="submit" style="cursor: hand;"
						class="btn btn-primary col-3">Iniciar sesión</button>
				</div>
			</form>
			<div class="text-center">
				<p class="d-inline-block mb-0">¿Todavia no tienes una cuenta?</p>
				<a href="#" class="font-weight-bold text-decoration-none">Crea
					una ahora</a>
			</div>
			<br>
			<div class="alert alert-dark">
				<h5 align="center"><%=a%></h5>
			</div>

		</div>
	</div>
</body>
</html>