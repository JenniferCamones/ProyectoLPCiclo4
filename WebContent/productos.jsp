<jsp:include page="validarEmpleado.jsp"></jsp:include>
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
    
    <link rel="stylesheet" href="./css/mantenimiento/inicioAdmin.css">

      <link rel="stylesheet" href="css/mantenimiento/empleaods.css">

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

		.campo{
		position: relative;}

		.archivoImagen{
		outline: none;
		display: none;
				}
				
				.labelImagen{
				color: white;
				height: 60px;
				width: 100%;
				background-color: orange;
				position: absolute;
				margin: auto;
				top: 0;
				bottom: 0;
				left: 0;
				right: 0;
				font-size: 18px;
				font-weight:bold;
				display: flex;
				justify-content: center;
				align-items: center;
				transition:all ease .3s;
					}
				
.labelImagen:hover{
    background-color: black;
}

.campoimagen{
	padding: 2rem 0px;
	text-shadow: 1px 1px 1px rgba(0,0,0,1);
}

.categorias{
	border: none;
	outline: none;
}
      </style>
 
</head>
  <body>
    <header class="header">
      <div class="header__container">
        <div class="header__encabezado">
          <div class="encabezado__texto encabezado__texto--1">
            <h2 class="encabezado__texto1">Atenci??n</h2>
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
          <a class="navegacion__enlace" href="consultar.jsp">Consultas</a>
          <a class="navegacion__enlace" href="reportes.jsp">Reportes</a>
          <a class="navegacion__enlace" href="realizarVenta.jsp">Ventas</a>
         

      
        </nav>
      </div>
    </header>

    <main class="__container">

 <h2 class="__heading" id="titulo">Mantenimiento Productos</h2>


    <div class="mantenimiento__grid">




      <form action="ServletProducto?tipo=agregar" method="post" enctype="multipart/form-data" class="formulario__crear">
        <div class="registrar__grid">
           <h3 class="__heading">Agregar Producto</h3>
    <div class="campo">

                <label for="codigo">Codigo:</label>
                <input readonly="readonly" type="text" name="txt_cod"  placeholder="Codigo Autogenerado">

            </div>
            
            
            
               <div class="campo campoimagen">

       
                <input class="archivoImagen" type="file" id="imagen" name="imagen"	  >
		         <label class="labelImagen" for="imagen">Selecciona Imagen</label>
            </div>
            
             <div class="campo">

                <label for="nombre">Nombre:</label>
                <input type="text" name="txt_nombre"  placeholder="Nombre">

            </div>
            
             <div class="campo">

                <label for="codigo">Categoria:</label>
                <select class="categorias" name="cbo_categoria">
                   <option value="1">Hamburguesas</option>
						<option value="2">Pizzas</option>
						<option value="3">Pasteles</option>
                </select>
            

            </div>
            

               
   <div class="campo">

                <label for="descripcion">Descripcion:</label>
                <input type="text" name="txt_descripcion"  placeholder="Descripcion">

            </div>

   <div class="campo">

                <label for="stock">Stock:</label>
                <input type="text" name="txt_stock"  placeholder="Stock">

            </div>

               <div class="campo">

                <label for="precio">Precio:</label>
                <input type="text" name="txt_precio"  placeholder="Precio">

            </div>


           
        </div>

        <button type="submit">Crear</button>
       

      </form>


        <form action="ServletProducto?tipo=actualizar" method="post" enctype="multipart/form-data" class="formulario__crear">
        <div class="registrar__grid">
           <h3 class="__heading">Actualizar Producto</h3>
    <div class="campo">

                <label for="codigo">Codigo:</label>
                <input value="${requestScope.Producto.codProducto}" type="text" readonly="readonly" name="txt_cod2"  placeholder="Codigo">

            </div>

                <div class="campo campoimagen">

       
                <input   class="archivoImagen" type="file" id="imagen2" name="imagen2"	   >
		         <label class="labelImagen" for="imagen">Selecciona Imagen</label>
            </div>
            
             <div class="campo">

                <label for="nombre">Nombre:</label>
                <input value="${requestScope.Producto.nombre}" type="text" name="txt_nombre2"  placeholder="Nombre">

            </div>
            
             <div class="campo">

                <label for="codigo">Categoria:</label>
                <select class="categorias" name="cbo_categoria2">
          <option value="1">Hamburguesas</option>
						<option value="2">Pizzas</option>
						<option value="3">Pasteles</option>
                </select>
            

            </div>
   <div class="campo">

                <label for="descripcion">Descripcion:</label>
                <input value="${requestScope.Producto.descripcion}" type="text" name="txt_descripcion2"  placeholder="Descripcion">

            </div>

   <div class="campo">

                <label for="stock">Stock:</label>
                <input value="${requestScope.Producto.stock}" type="text" name="txt_stock2"  placeholder="Stock">

            </div>

               <div class="campo">

                <label for="precio">Precio:</label>
                <input value="${requestScope.Producto.precio}" type="text" name="txt_precio2"  placeholder="Precio">

            </div>


           
        </div>

        <button type="submit">Actualizar</button>
        

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
            <a href="https://www.facebook.com/DominosPeru/" target="_blank"><img src="img/facebook.png" alt="" /></a>
            <a href="https://www.youtube.com/watch?v=FD7muZsSd28" target="_blank"><img src="img/youtube.png" alt="" /></a>
            <a href="https://twitter.com/dominos_peru" target="_blank"><img src="img/twitter.png" alt="" /></a>
            <a href="https://www.instagram.com/dominosperu/" target="_blank"><img src="img/instagram.png" alt="" /></a>
          </div>
        </div>

        <div class="footer__copyright">
          <br />
          <hr />
          <p>?? 2022 Todos los derechos Reservados.</p>
        </div>
      </div>
    </footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>
