<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Base</title>

    
    <link rel="stylesheet" href="../css/normalize.css" />
    
    <link rel="stylesheet" href="../css/base.css" />
    
    <link rel="stylesheet" href="../css/base-mobile.css" />
    
    <link rel="stylesheet" href="../css/mantenimiento/listaProducto.css">
    
    <link rel="stylesheet" href=".././css/menu/menu.css">
    
    <link rel="stylesheet" href=".././css/mantenimiento/inicioAdmin.css">
         <link rel="stylesheet" href="../css/mantenimiento/empleaods.css">

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
      integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />

        <style>
        .boton-salir{
          text-decoration: none;
          color: black;
          font-weight: bold;
      
        }
        .boton-salir i{
          color: rgb(139, 3, 3);
        }
        
          .boton-salir:hover{
        text-decoration: underline;
        
        }
        .navegacion{
          gap: 10rem;
        }

        @media (max-width:768px){
           .navegacion{
          gap: 3rem;
        }
        }

        .__container{
          text-align: center;
          padding: 3rem 2rem;
        }

      </style>
 
</head>
  <body>
    <header class="header">
      <div class="header__container">
        <div class="header__encabezado">
          <div class="encabezado__texto encabezado__texto--1">
            <h2 class="encabezado__texto1">Atención</h2>
            <h2 class="encabezado__texto1">en Lima*</h2>
          </div>

          <div class="encabezado__texto encabezado__texto--2">
            <h2 class="encabezado__texto2">Delibery: Hasta las 11pm*</h2>
            <h2 class="encabezado__texto2">Recojo en tienda: Hasta las 9pm*</h2>
          </div>
        </div>

        <div class="header__barra">
          <div class="header__logo">
            <a href="/"
              ><img
                class="header__logo--img"
                src="img/delibery-logo.jpg"
                alt=""
            /></a>
          </div>

          <div class="header__derecho">
            <div class="header__telefono">
              <div class="header__telefono--superior">
                <img
                  class="header__telefono--img"
                  src="img/telefono.png"
                  alt=""
                />
                <p>Delibery</p>
              </div>
              <div class="header__telefono--inferior">
                <p>014191919</p>
              </div>
            </div>
  <div class="header__admin">
            
              <a href="inicioVisitante.jsp" class="boton-salir"> <i class="fa-sharp fa-solid fa-right-from-bracket"></i> Salir</a>


            </div>
          </div>
        </div>

        <nav class="navegacion">
          <select class="mantenimiento" name="" id="" onchange="location=this.value;" >
            <option selected="true"  value="" disabled="disabled" >Mantenimiento</option>
          <option value="empleados.jsp" >Empleados </option>
                <option  value="productos.jsp"  >Productos</option>
                  <option  value="locales.jsp" >Locales</option>
                    <option  value="proveedores.jsp"  >Proveedores</option>

          </select>
          <a class="navegacion__enlace" href="../consultas/consultar.jsp">Consultas</a>
          <a class="navegacion__enlace" href="../reportes/reportes.jsp">Reportes</a>
          <a class="navegacion__enlace" href="../ventas/realizarVenta.jsp">Ventas</a>
         

      
        </nav>
      </div>
    </header>

    <main class="__container">

 <h2 class="__heading" id="titulo">Mantenimiento Proveedores</h2>


    <div class="mantenimiento__grid">




      <form action="" class="formulario__crear">
        <div class="registrar__grid">
           <h3 class="__heading">Agregar Proveedor</h3>
    <div class="campo">

                <label for="codigo">Codigo:</label>
                <input type="text" name="codigo"  placeholder="Codigo">

            </div>

                <div class="campo">

                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre"  placeholder="Nombre">

            </div>
   <div class="campo">

                <label for="direccion">Direccion:</label>
                <input type="text" name="direccion"  placeholder="Direccion">

            </div>

   <div class="campo">

                <label for="correo">Correo:</label>
                <input type="text" name="correo"  placeholder="Correo">

            </div>

        


           
        </div>

        <button type="submit">Crear</button>
        <button>Nuevo</button>

      </form>


      <form action="" class="formulario__crear">
        <div class="registrar__grid">
           <h3 class="__heading">Actualizar Proveedor</h3>
    <div class="campo">

                <label for="codigo">Codigo:</label>
                <input type="text" name="codigo"  placeholder="Codigo">

            </div>

                <div class="campo">

                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre"  placeholder="Nombre">

            </div>
   <div class="campo">

                <label for="direccion">Direccion:</label>
                <input type="text" name="direccion"  placeholder="Direccion">

            </div>

   <div class="campo">

                <label for="correo">Correo:</label>
                <input type="text" name="correo"  placeholder="Correo">

            </div>

        


           
        </div>

        <button type="submit">Actualizar</button>
        <button>Listar Proveedores</button>

      </form>

      



    </div>



      
       

    </main>

    <footer class="footer">
      <div class="footer__container">
        <div class="footer__logo">
          <a href="/"
            ><img
              class="footer__logo--img"
              src="img/delibery-logo-sinfondo.png"
              alt=""
          /></a>
        </div>

        <div class="footer__enlaces">
          <nav class="footer__navegacion">
            <a class="footer__enlace" href="index.jsp">Menu</a>
            <a class="footer__enlace" href="nosotros.jsp">Promociones</a>
            <a class="footer__enlace" href="blog.jsp">Locales</a>
            <a class="footer__enlace" href="tienda.jsp">Nosotros</a>
          </nav>

          <div class="footer__redes">
            <a href=""><img src="../img/facebook.png" alt="" /></a>
            <a href=""><img src="../img/youtube.png" alt="" /></a>
            <a href=""><img src="../img/twitter.png" alt="" /></a>
            <a href=""><img src="../img/instagram.png" alt="" /></a>
          </div>
        </div>

        <div class="footer__copyright">
          <br />
          <hr />
          <p>© 2022 Todos los derechos Reservados.</p>
        </div>
      </div>
    </footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>
