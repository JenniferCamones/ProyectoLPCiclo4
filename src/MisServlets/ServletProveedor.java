package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmpleadosDTO;
import beans.ProveedorDTO;
import service.ProveedorService;

/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProveedorService servicio=new ProveedorService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
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
		
	}
	

	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codemp, nombre,apellido,telefono,direccion,correo,usuario,clave;
		int idTipo;
		codemp=servicio.generaCodigo();
		nombre=request.getParameter("txt_nombre");
		
		direccion=request.getParameter("txt_direccion");
		correo=request.getParameter("txt_correo");
	
		
		idTipo=3;
	
		
		
		if(codemp.equals("")|| nombre.equals("")	|| direccion.equals("")	|| correo.equals("")) {
			return;
		}
		
		
		
		
		
		ProveedorDTO prov = new ProveedorDTO();
		prov.setCodProv(codemp);
		prov.setNombre(nombre);

		prov.setDireccion(direccion);
		prov.setCorreo(correo);
	
		servicio.agregaProveedor(prov);
		listar(request, response);
		
		
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nombre,direccion,correo;
		
		
		nombre=request.getParameter("txt_nombre2");
		
			
		direccion=request.getParameter("txt_direccion2");
		correo=request.getParameter("txt_correo2");
		cod=request.getParameter("txt_cod2");
		ProveedorDTO prov=new ProveedorDTO();
		
		
		prov.setNombre(nombre);
	
		prov.setDireccion(direccion);
		prov.setCorreo(correo);
		prov.setCodProv(cod);
	
		
	
		servicio.actualizaProveedor(prov);
		listar(request, response);
	}

	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("cod");
		servicio.eliminaProveedor(cod);
		listar(request, response);
	}
	
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod=request.getParameter("cod");
		
		request.setAttribute("Proveedor", servicio.buscaProveedor(cod));
		request.getRequestDispatcher("proveedores.jsp").forward(request, response);
	}
	
	
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data", servicio.listaProveedor());
		((HttpServletRequest) request).getRequestDispatcher("listarProveedores.jsp").forward(request, response); 
		
	}
	
	
	
}
