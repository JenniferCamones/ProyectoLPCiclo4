<jsp:include page="validar.jsp"></jsp:include>
<%@page import="beans.LocalDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Base</title>
    <link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/base-mobile.css">
    <link rel="stylesheet" href="css/menu/locales.css">
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
            ><img class="header__logo--img" src="img/delibery-logo.jpg" alt=""
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
            <a class="navegacion__enlace" href="inicioUsuario.jsp">Menu</a>
          
            <a class="navegacion__enlace active" href="ServletLocal?tipo=listarLocales">Locales</a>
            <a class="navegacion__enlace" href="nosotros.jsp">Nosotros</a>
        <a class="navegacion__enlace" href="contactenos.jsp">Contactenos</a>
            <a class="navegacion__enlace--carrito" href="carrito.jsp"><p>Carrito</p> <img class="carrito__img" src="img/carrito.png" alt=""></a>

          </nav>



      </div>
    </header>


   <main class="__container">
      <h2 class="__heading">Nuestros Locales</h2>

    <div class="locales__grid">

     



             <%
          
      	ArrayList<LocalDTO> lista = (ArrayList<LocalDTO>) request.getAttribute("data");

			if (lista != null) {
		for (LocalDTO xLoc : lista) {
			
			
			out.println("<div class='local'>");
			out.println("<div class='local__provincia'>");
			out.println("<h3  class='local__pronvincia-nombre'>" + xLoc.getDepartamento() + "</h3>");
			out.println(" </div>"	);
			out.println("<div class='local__distrito'>");
			out.println(" <h3 class='local__distrito-nombre'>" + xLoc.getDistrito() + "</h3>");
			   
			out.println(" <div class='local__distrito-info'>");
			   
						out.println(" <div class='local__direccion'>");
			
						out.println("<p>" + xLoc.getDireccion() + "</p>");	
						

						out.println(" </div>"	);
						out.println("<div class='local__telefono'>"	);
						
						out.println("<p>" + xLoc.getTelefono() + "</p>");
						
						out.println(" </div>"	);
						out.println(" </div>"	);
						out.println(" </div>"	);
						out.println(" </div>"	);
						
						
			
			
			
		}
			}
          
          
          

            %>



    </div>

     
    </main>


    <footer class="footer">

        <div class="footer__container">

            <div class="footer__logo">

               <a href="/"><img class="footer__logo--img" src="img/delibery-logo-sinfondo.png" alt=""></a> 

            </div>


            <div class="footer__enlaces">

    <nav class="footer__navegacion">
                <a class="footer__enlace" href="index.jsp">Menu</a>
                <a class="footer__enlace" href="nosotros.jsp">Promociones</a>
                <a class="footer__enlace" href="blog.jsp">Locales</a>
                <a class="footer__enlace" href="tienda.jsp">Nosotros</a>

                    
            </nav>

            <div class="footer__redes">

             <a href=""><img src="img/facebook.png" alt=""></a>   
           <a href=""><img src="img/youtube.png" alt=""></a>     
            <a href=""><img src="img/twitter.png" alt=""></a>    
               <a href=""><img src="img/instagram.png" alt=""></a> 


            </div>


            </div>

          
            <div class="footer__copyright">
                <br>
                <hr>
                <p>© 2022 Todos los derechos Reservados.</p>

            </div>





        </div>

    </footer>



  </body>
</html>
