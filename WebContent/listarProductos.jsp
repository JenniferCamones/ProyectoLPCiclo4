<jsp:include page="validarEmpleado.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="beans.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Base</title>

    
    <link href="<c:url value="/css/normalize.css"/>"  rel="stylesheet" />
    
    <link rel="stylesheet" href="/css/base.css" />
    
    <link rel="stylesheet" href="/css/base-mobile.css" />
    
    <link rel="stylesheet" href="/css/mantenimiento/listaProducto.css">
    
    <link rel="stylesheet" href="/./css/menu/menu.css">
    
    <link rel="stylesheet" href="/./css/mantenimiento/inicioAdmin.css">
      <link rel="stylesheet" href="/./css/carrito.css">










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
            <h2 class="encabezado__texto1">Atenci????n</h2>
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
          <a class="navegacion__enlace active" href="consultar.jsp">Consultas</a>
          <a class="navegacion__enlace" href="reportes.jsp">Reportes</a>
          <a class="navegacion__enlace" href="realizarVenta.jsp">Ventas</a>
         

      
        </nav>
      </div>
    </header>

    <main class="__container">


    <h2 class="__heading">Lista Productos</h2>
      <div class="formulario-busqueda">
        <form action="consultar.jsp" class="buscador" >

            <div class="opciones">
                <select name="lista" class="categorias" id="categoria" >
                        <option value="empleados">Empleados</option>
                        <option value="locales">Locales</option>
                             <option value="productos">Productos</option>
                        <option value="proveedores">Proveedores</option>
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

                           <div class="table_responsive">
        <table class="tabla">
          <thead>
            <tr>
            <th>Codigo </th>
              <th>Imagen</th>
              <th>Nombre</th>
              <th>Categoria</th>
              <th>Descripcion</th>
                <th>Stock</th>
                 <th>Precio</th>
                  <th>FechaRegistro</th>
                  
<th>Acciones</th>
            </tr>
          </thead>

          <tbody>
                   <%
          
      	ArrayList<ProductoDTO> lista = (ArrayList<ProductoDTO>) request.getAttribute("data");

			if (lista != null) {
		for (ProductoDTO xProd : lista) {
			out.println("<tr>");
			out.println("<td>" + xProd.getCodProducto() + "</td>");
			out.println("<td><img src='ServletProducto?xtipo=listarImg&cod="+xProd.getCodProducto()+"' ></td>");
			
			out.println("<td>" + xProd.getNombre() + "</td>");
			out.println("<td>" + xProd.getCategoria() + "</td>");
			out.println("<td>" + xProd.getDescripcion() + "</td>");
			out.println("<td>" + xProd.getStock() + "</td>");
			out.println("<td>" + xProd.getPrecio() + "</td>");
			out.println("<td>" + xProd.getFechaRegistro() + "</td>");
			out.println("<td '> <span class='action_btn'><a href='ServletProducto?tipo=buscar&cod=" + xProd.getCodProducto() + "'>"
			+ "<i class='fa-sharp fa-solid fa-edit'></i></a><a href='ServletProducto?tipo=eliminar&cod=" + xProd.getCodProducto() + "'>"
			+ "<i class='fa-sharp fa-solid fa-trash'></i></a> </span></td>  </tr>"	);
			
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
            <a href=""><img src="img/facebook.png" alt="" /></a>
            <a href=""><img src="img/youtube.png" alt="" /></a>
            <a href=""><img src="img/twitter.png" alt="" /></a>
            <a href=""><img src="img/instagram.png" alt="" /></a>
          </div>
        </div>

        <div class="footer__copyright">
          <br />
          <hr />
          <p>???? 2022 Todos los derechos Reservados.</p>
        </div>
      </div>
    </footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>
