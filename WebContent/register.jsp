<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/register/register.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="sweetalert2.min.css">
</head>
<body>
    
    <div class="form-container">


        <form class="formulario" action="ServletCliente?tipo=agregar" id="formulario" method="post">

            <div class="logo">
                <img src="img/delibery-logo-sinfondo.png" alt="">
            </div>

            <h2>Registrese en Delivery</h2>
            <div class="campos">
  <div class="campo">

                <label for="nombre">Nombre:</label>
                <input type="text" name="txt_nombre" id="nombre" placeholder="Ingresa su nombre">

            </div>
              <div class="campo">

                <label for="apellido">Apellido:</label>
                <input type="text" name="txt_apellido" id="apellido" placeholder="Ingresa su apellido">

            </div>
             <div class="campo">

                <label for="telefono">Telefono:</label>
                <input type="text" name="txt_telefono" id="telefono" placeholder="Ingresa  telefono ">

            </div>
             <div class="campo">

                <label for="direccion">Direccion:</label>
                <input type="text" name="txt_direccion" id="direccion" placeholder="Ingresa  direccion ">

            </div>
              <div class="campo">

                <label for="usuario">Usuario:</label>
                <input type="text" name="txt_usuario" id="usuario" placeholder="Ingresa  usuario">

            </div>


            <div class="campo">

                <label for="correo">Correo:</label>
                <input type="text" name="txt_correo" id="correo" placeholder="Ingresa tu correo">

            </div>

                <div class="campo">

                <label for="contrasena">Contraseña:</label>
                <input type="password" name="txt_clave" id="contrasena" placeholder="Ingresa Contraseña">

            </div>

            
                <div class="campo">

                <label for="confirmar">Confirme contraseña:</label>
                <input type="password" name="txt_repassword" id="confirmar" placeholder="Ingresa Contraseña">

            </div>
            </div>

       

         

            <button class="boton-enviar" id="botonRegistrar" type="submit">Registrarse</button>

           
            <a href="login.jsp">Ya tienes cuenta?</a>

        </form>


    </div>


<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.min.js"></script>
<script src="./js/registrarCliente.js"></script>
</body>
</html>