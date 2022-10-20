<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/login/login.css">
    <link rel="stylesheet" href="css/normalize.css">
</head>
<body>
    <%
    String x =(String) request.getAttribute("msj");
    String a="";
    if(x!=null)
    	a=x;
   %>
    <div class="form-container">


        <form class="formulario" action="ServletUsuario" name="frmsesion" method="post">

            <div class="logo">
                <img src="img/delibery-logo-sinfondo.png" alt="">
            </div>

            <h2>Ingresa a Delivery</h2>

            <div class="campo">

                <label for="correo">Usuario:</label>
                <input type="text" name="txtUsuario" id="correo" placeholder="Ingresa tu usuario">

            </div>

                <div class="campo">

                <label for="password">Contraseña:</label>
                <input type="password" name="txtClave" id="password" placeholder="Ingresa Contraseña">

            </div>

            <div class="campo-grid">

                   

                <div class="campo campo--recuerdame">

                <label for="recuerdame">Recuerdame:</label>
                <input type="checkbox" name="recuerdame" id="recuerdame">

            </div>
            
            <div class="vacio"></div>
           
            </div>

         

            <button class="boton-enviar" type="submit">Ingresar</button>

            <a href="#">Recuperar Contraseña</a>
            <a href="#">Registrarse</a>
            <h5 align="center"><%=a%></h5>

        </form>


        <div class="volver">
       <a href="#">Volver</a>
        </div>


    </div>





</body>
</html>