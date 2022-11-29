<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="beans.ReporteVentas"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Base</title>
    
   <link href="<c:url value="/css/normalize.css" />" 
rel="stylesheet">
 
   <link href="<c:url value="/css/base.css" />" 
rel="stylesheet">

 <link href="<c:url value="/css/base-mobile.css" />" 
rel="stylesheet">

 <link href="<c:url value="/css/mantenimiento/listaProducto.css" />" 
rel="stylesheet">

    <link href="<c:url value="/./css/menu/menu.css" />" 
rel="stylesheet">
    
      <link href="<c:url value="/./css/mantenimiento/inicioAdmin.css"/>" 
rel="stylesheet">
    
        <link href="<c:url value="/./css/carrito.css"/>" 
rel="stylesheet">
    
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

        .container-1 label i{
          margin-left: -28rem;
        }

            .table_responsive{
                margin-top: 5rem;
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
            <h2 class="encabezado__texto2">Delivery: Hasta las 11pm*</h2>
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
                <p>Delivery</p>
              </div>
              <div class="header__telefono--inferior">
                <p>014191919</p>
              </div>
            </div>
  <div class="header__admin">
            
              <a href="ServletEmpleado?tipo=cerrarSesion" class="boton-salir"> <i class="fa-sharp fa-solid fa-right-from-bracket"></i> Salir</a>


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
          <a class="navegacion__enlace" href="consultar.jsp">Consultas</a>
          <a class="navegacion__enlace active" href="reportes.jsp">Reportes</a>
          <a class="navegacion__enlace" href="realizarVenta.jsp">Ventas</a>
         

      
        </nav>
      </div>
    </header>

    <main class="__container">


    <h2 class="__heading">Reporte Detalle de Ventas</h2>
      <div class="formulario-busqueda">
        <form action="consultar.jsp" class="buscador" >

          <div class="opciones">               
            </div>
 
		  </div>   
        </form>
     </div>

                           <div class="table_responsive2">
        <table class="tabla">
          <thead>
            <tr>
             <th>N° Boleta</th>
              <th>Fecha</th>
              <th>Cod cliente</th>
              <th>Cliente</th>
              <th>Cod Empleado</th>
              <th>Empleado</th>
              <th>Importe total</th>
              <th>cod Producto</th>
              <th>cantidad</th>
              <th>precio</th>
              <th>importe total</th>
            </tr>
          </thead>

          <tbody>
          
          <%
          
      	ArrayList<ReporteVentas> lista = (ArrayList<ReporteVentas>) request.getAttribute("data");

			if (lista != null) {
		for (ReporteVentas xEmp : lista) {
			out.println("<tr>");
			out.println("<td>" + xEmp.getNumeroBoleta() + "</td>");
			out.println("<td>" + xEmp.getFechaBoleta() + "</td>");
			out.println("<td>" + xEmp.getCodigoCliente() + "</td>");
			out.println("<td>" +xEmp.getNombreCompletoCli() + "</td>");
			out.println("<td>" + xEmp.getCodigoEmpleado()+ "</td>");
			out.println("<td>" + xEmp.getNombreCompletoEmp() + "</td>");
			out.println("<td>" + xEmp.getTotalBoleta() + "</td>");
			out.println("<td>" + xEmp.getCodProducto() + "</td>");
			out.println("<td>" + xEmp.getCantidad() + "</td>");
			out.println("<td>" + xEmp.getPrecioUnidad() + "</td>");
			out.println("<td>" + xEmp.getImporteTotal() + "</td>");
			out.println("</tr>");
		}
			}
          
          
          

            %>
                        
          </tbody>

        </table>
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
            <a href="https://www.facebook.com/DominosPeru/" target="_blank"><img src="img/facebook.png" alt="" /></a>
            <a href="https://www.youtube.com/watch?v=FD7muZsSd28" target="_blank"><img src="img/youtube.png" alt="" /></a>
            <a href="https://twitter.com/dominos_peru" target="_blank"><img src="img/twitter.png" alt="" /></a>
            <a href="https://www.instagram.com/dominosperu/" target="_blank"><img src="img/instagram.png" alt="" /></a>
          </div>
        </div>

        <div class="footer__copyright">
          <br />
          <hr />
          <p>Â© 2022 Todos los derechos Reservados.</p>
        </div>
      </div>
    </footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>