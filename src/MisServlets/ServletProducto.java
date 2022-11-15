package MisServlets;


import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.ProductoDTO;
import service.ProductoService;
/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)  
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService servicio = new ProductoService(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
	
		 if (xtipo.equals("agregar")) {
			agregar(request, response);
		}if (xtipo.equals("listar")) {
			listar(request, response);
		}	else if (xtipo.equals("actualizar")) {
			actualizar(request, response);
		}
		else if (xtipo.equals("eliminar")) {
			eliminar(request, response);
		}
		else if (xtipo.equals("buscar")) {
			buscar(request, response);
		}
		else if (xtipo.equals("listarLocales")) {
			listarProductos(request, response);
		}else if (xtipo.equals("listarImg")) {
			listarImg(request, response);
		}
		
	}
	
	private String obtenerFecha() {
		// Obtener la fecha del sistema
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}

	
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nombre,descripcion,fechaRegistro;
		Part imagen;
		int categoria,stock;
		double precio;
		
		cod=servicio.generaCodigo();
			imagen=request.getPart("imagen");
			
		InputStream inputStream=imagen.getInputStream();

		
		
		nombre=request.getParameter("txt_nombre");
		categoria = Integer.parseInt(request.getParameter("cbo_categoria"));
		
		descripcion=request.getParameter("txt_descripcion");
		stock = Integer.parseInt(request.getParameter("txt_stock"));
		precio = Double.parseDouble(request.getParameter("txt_precio"));
		
		fechaRegistro=obtenerFecha();
	
		
	
		
		ProductoDTO prod= new ProductoDTO();
		prod.setCodProducto(cod);
		prod.setImagen(inputStream);
		prod.setNombre(nombre);
		prod.setIdCategoriaProducto(categoria);
		prod.setDescripcion(descripcion);
		prod.setStock(stock);
		prod.setPrecio(precio);
		prod.setFechaRegistro(fechaRegistro);
		servicio.agregaProducto(prod);
		listar(request, response);
		
		
	}
	
	
	
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nombre,descripcion,fechaRegistro;
		Part imagen;
		int categoria,stock;
		double precio;
		
	
		imagen=request.getPart("imagen2");
		
		InputStream inputStream=imagen.getInputStream();
		
		
		nombre=request.getParameter("txt_nombre2");
		categoria = Integer.parseInt(request.getParameter("cbo_categoria2"));
		
		descripcion=request.getParameter("txt_descripcion2");
		stock = Integer.parseInt(request.getParameter("txt_stock2"));
		precio = Double.parseDouble(request.getParameter("txt_precio2"));
		
		fechaRegistro=obtenerFecha();
		cod=request.getParameter("txt_cod2");
		
	
		
		ProductoDTO prod= new ProductoDTO();
		
		
		
		prod.setImagen(inputStream);
		prod.setNombre(nombre);
		prod.setIdCategoriaProducto(categoria);
		prod.setDescripcion(descripcion);
		prod.setStock(stock);
		prod.setPrecio(precio);
		prod.setFechaRegistro(fechaRegistro);
		prod.setCodProducto(cod);
		
		servicio.actualizaProducto(prod);
		listar(request, response);
		
	}

	
	
	
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("cod");
		servicio.eliminaProducto(cod);
		listar(request, response);
	}
	
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod=request.getParameter("cod");
		
		request.setAttribute("Producto", servicio.buscaProducto(cod));
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}
	
	
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data", servicio.listaProducto());
		((HttpServletRequest) request).getRequestDispatcher("listarProductos.jsp").forward(request, response); 
		
	}
	
	private void listarProductos(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data", servicio.listaProducto());
		((HttpServletRequest) request).getRequestDispatcher("inicioUsuario.jsp").forward(request, response); 
		
	}
	


	private void listarImg(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cod=request.getParameter("cod");
		
		servicio.listaImg(cod,response);
		
		
	
	}
	
	
	
	
	
	
}
