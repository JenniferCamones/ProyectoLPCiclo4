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


        <form class="formulario" action="">

            <div class="logo">
                <img src="img/delibery-logo-sinfondo.png" alt="">
            </div>

            <h2>Ingresa a Delivery</h2>

            <div class="campo">

                <label for="usuario">Usuario:</label>
                <input type="text" name="usuario" id="usuario" placeholder="Ingresa  Usuario" autocomplete="off">

            </div>

                <div class="campo">

                <label for="password">Contraseña:</label>
                <input type="password" name="password" id="password" placeholder="Ingresa Contraseña">

            </div>

            <div class="campo-grid">

                   

                <div class="campo campo--recuerdame">

                <label for="recuerdame">Recuerdame:</label>
                <input type="checkbox" name="recuerdame" id="recuerdame">

            </div>
            
            <div class="vacio"></div>
           
            </div>

         

            <button class="boton-enviar" type="submit">Ingresar</button>

           
            <a href="register.jsp">Registrarse</a>

        </form>


 


    </div>





</body>
</html>