<jsp:include page="validar.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Base</title>

    
    <link rel="stylesheet" href="css/normalize.css" />
    
    <link rel="stylesheet" href="css/base.css" />
    
    <link rel="stylesheet" href="css/base-mobile.css" />
    
    <link rel="stylesheet" href="css/mantenimiento/listaProducto.css">
    
    <link rel="stylesheet" href="./css/menu/menu.css">
    
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

            <div class="header__usuario">
            
              <a href="ServletCliente?tipo=cerrarSesion" class="boton-salir"> <i class="fa-sharp fa-solid fa-right-from-bracket"></i> Salir</a>


            </div>
          </div>
        </div>

        <nav class="navegacion">
          <a class="navegacion__enlace active" href="inicioUsuario.jsp" >Menu</a>
        
          <a class="navegacion__enlace" href="./paginas/locales.jsp">Locales</a>
          <a class="navegacion__enlace" href="./paginas/nosotros.jsp">Nosotros</a>
  <a class="navegacion__enlace" href="./paginas/contactenos.jsp">Contactenos</a>
          <a class="navegacion__enlace--carrito" href="carrito.jsp"
            ><p>Carrito</p>
            <img class="carrito__img" src="img/carrito.png" alt=""
          /></a>
        
        </nav>
      </div>
    </header>

    <main class="__container">


<div class="banner animated tada">

</div>

      <h2 class="__heading">Nuestros Menú</h2>

        <div class="formulario-busqueda">
        <form action="inicioUsuario.jsp" class="buscador" >

            <div class="opciones">
                <select name="categoria" class="categorias" id="categoria" class="select">
                        <option value="1">Bebidas</option>
                        <option value="2">Postres</option>
                </select>
            </div>

            <div class="box">
  <div class="container-1">
      <label class="icon"><i class="fa fa-search"></i></label>
      <input type="search" name="buscar" id="search" placeholder="Buscar..." autocomplete="off" />
      
  </div>

</div>
   
        </form>
     </div>

       <div class="productos__grid">
        <!--Inicio Producto-->
        <div class="producto">
          <img
            class="producto__imagen"
           src="img/hamburguesa.jpg"
            alt="imagen comida"
          />

          <div class="producto__contenido">
            <h3 class="producto__nombre">Lukather</h3>
            <p class="producto__descripcion">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dicta
              iusto architecto nemo possimus inventore quae.
            </p>

            <p class="producto__precio">$299</p>
            <a class="producto__enlace" href="producto.jsp">Ver Producto</a>
          </div>
        </div>

          <!--Inicio Producto-->
        <div class="producto">
          <img
            class="producto__imagen"
            src="img/hamburguesa.jpg"
            alt="imagen comida"
          />

          <div class="producto__contenido">
            <h3 class="producto__nombre">Lukather</h3>
            <p class="producto__descripcion">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dicta
              iusto architecto nemo possimus inventore quae.
            </p>

            <p class="producto__precio">$299</p>
            <a class="producto__enlace" href="producto.jsp">Ver Producto</a>
          </div>
        </div>

          <!--Inicio Producto-->
        <div class="producto">
          <img
            class="producto__imagen"
             src="img/hamburguesa.jpg"
            alt="imagen comida"
          />

          <div class="producto__contenido">
            <h3 class="producto__nombre">Lukather</h3>
            <p class="producto__descripcion">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dicta
              iusto architecto nemo possimus inventore quae.
            </p>

            <p class="producto__precio">$299</p>
            <a class="producto__enlace" href="producto.jsp">Ver Producto</a>
          </div>
        </div>
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
            <a href=""><img src="img/facebook.png" alt="" /></a>
            <a href=""><img src="img/youtube.png" alt="" /></a>
            <a href=""><img src="img/twitter.png" alt="" /></a>
            <a href=""><img src="img/instagram.png" alt="" /></a>
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
