package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LocalDTO;
import beans.ProveedorDTO;
import service.LocalService;

/**
 * Servlet implementation class ServletLocal
 */
@WebServlet("/ServletLocal")
public class ServletLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LocalService servicio= new LocalService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLocal() {
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
			listarLocales(request, response);
		}
		
	}
	
	
	
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,departamento,distrito,direccion,telefono;
		
		cod=servicio.generaCodigo();
		departamento=request.getParameter("txt_departamento");
		
		distrito=request.getParameter("txt_distrito");
		direccion=request.getParameter("txt_direccion");
		telefono=request.getParameter("txt_telefono");
		
	
		
		
		if(cod.equals("")|| departamento.equals("")	|| distrito.equals("")	|| direccion.equals("")|| telefono.equals("")) {
			return;
		}
		
		
		
		
		
		LocalDTO loc= new LocalDTO();
		loc.setCodLoc(cod);
		loc.setDepartamento(departamento);
		loc.setDistrito(distrito);
		loc.setDireccion(direccion);
		loc.setTelefono(telefono);
	
		servicio.agregaLocal(loc);
		listar(request, response);
		
		
	}
	

	
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,departamento,distrito,direccion,telefono;
		
		
		departamento=request.getParameter("txt_departamento2");
		
			
		distrito=request.getParameter("txt_distrito2");
		direccion=request.getParameter("txt_direccion2");
		telefono=request.getParameter("txt_telefono2");
		cod=request.getParameter("txt_cod2");
		LocalDTO loc=new LocalDTO();
		
		
		loc.setDepartamento(departamento);
	
		loc.setDistrito(distrito);
		loc.setDireccion(direccion);
		loc.setTelefono(telefono);
		loc.setCodLoc(cod);
	
		
	
		servicio.actualizaLocal(loc);
		listar(request, response);
	}

	
	
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("cod");
		servicio.eliminaLocal(cod);
		listar(request, response);
	}
	
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod=request.getParameter("cod");
		
		request.setAttribute("Local", servicio.buscaLocal(cod));
		request.getRequestDispatcher("locales.jsp").forward(request, response);
	}
	
	
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data", servicio.listaLocal());
		((HttpServletRequest) request).getRequestDispatcher("listarLocales.jsp").forward(request, response); 
		
	}
	private void listarLocales(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data", servicio.listaLocal());
		((HttpServletRequest) request).getRequestDispatcher("nuestrosLocales.jsp").forward(request, response); 
		
	}
	
	
}
