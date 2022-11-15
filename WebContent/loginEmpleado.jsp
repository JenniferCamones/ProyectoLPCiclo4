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
    
    <div class="form-container">


        <form class="formulario" action="ServletEmpleado?tipo=sesion" method="post">

            <div class="logo">
                <img src="img/delibery-logo-sinfondo.png" alt="">
            </div>

            <h2>Login Empleado</h2>

            <div class="campo">

                <label for="usuario">Usuario:</label>
                <input type="text" name="txt_login" id="usuario" placeholder="Ingresa  Usuario" autocomplete="off">
	
            </div>

                <div class="campo">

                <label for="password">Contraseña:</label>
                <input type="password" name="txt_clave" id="password" placeholder="Ingresa Contraseña">

            </div>

            <div class="campo-grid">

                   

                

         <a href="login.jsp" style="padding: 1rem 0">Login Cliente</a>

           
           
            </div>

         

            <button class="boton-enviar" type="submit">Ingresar</button>

           
            

        </form>


 


    </div>





</body>
</html>