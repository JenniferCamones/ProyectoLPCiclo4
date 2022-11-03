<%@page import="beans.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
   <table border="2" align="center" width="75%">
      <tr>
         <th>PRODUCTO</th>
         <th>NOMBRE</th>
         <th>STOCK</th>
         <th>PRECIO</th>
         <th>FECHA REGISTRO</th>
         <th>EMPLEADO REGISTRO</th>
         <th>FECHA MODIFICA</th>
         <th>EMPLEADO MODIFICA</th>
         <th>CATEGORIA</th>
         <th colspan="2">ACCIONES</th>
      </tr>
      <%
         ArrayList<ProductoDTO> lista = (ArrayList<ProductoDTO>) request.getAttribute("data");
      if (lista != null) {
         for (ProductoDTO xPro : lista) {
            out.println("<tr>");
            out.println("<td>" + xPro.getIdProducto() + "</td>");
            out.println("<td>" + xPro.getNombre() + "</td>");
            out.println("<td>" + xPro.getStockActual() + "</td>");
            out.println("<td>" + xPro.getPrecioActual() + "</td>");
            out.println("<td>" + xPro.getFechaRegistro() + "</td>");
            out.println("<td>" + xPro.getEmpleadoRegistro() + "</td>");
            out.println("<td>" + xPro.getFechaModifica() + "</td>");
            out.println("<td>" + xPro.getEmpleadoModifica() + "</td>");
            out.println("<td>" + xPro.getIdCategoriaPro() + "</td>");
            out.println("<td align='center'><a href='ServletProducto?tipo=buscar&cod=" + xPro.getIdProducto() + "'>"
            + "<img src='editar.png' title='Editar'></a></td>");
            out.println("<td align='center'><a href='ServletProducto?tipo=eliminar&cod=" + xPro.getIdProducto() + "'>"
            + "<img src='eliminar.png' title='Eliminar'></a></td>");
         }
      }
      %>
   </table>
</body>

</html>