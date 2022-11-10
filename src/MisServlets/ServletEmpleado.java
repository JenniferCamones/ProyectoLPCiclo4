package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteDTO;
import beans.EmpleadosDTO;
import service.EmpleadoService;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmpleadoService servicio=new EmpleadoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
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
		if(xtipo.equals("sesion")) {
			iniciarSesion(request,response);
		}else if(xtipo.equals("cerrarSesion"))
			CerrarSesion(request,response);
		else if (xtipo.equals("agregar")) {
			agregar(request, response);
		}
	
	}
	private void CerrarSesion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession();
		sesion.invalidate();
	      request.setAttribute("msg", "Iniciar Sesion");

	         request.getRequestDispatcher("loginEmpleado.jsp").forward(request, response);
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xlogin=request.getParameter("txt_login");
		String xclave=request.getParameter("txt_clave");
		System.out.println("Login:  "+xlogin); 
		System.out.println("Clave:  "+xclave);	
		
		EmpleadosDTO obj=servicio.iniciaSesion(xlogin);
		if(obj !=null) {
			if(obj.getClave().equals(xclave)) {
				HttpSession sesion=request.getSession();
				sesion.setAttribute("datos",obj);
				request.getRequestDispatcher("inicioAdmin.jsp").forward(request,response);
			}else {
				request.setAttribute("msg","Contraseña Incorrecta");
				request.getRequestDispatcher("loginEmpleado.jsp").forward(request,response);
			}
		}else {
		       request.setAttribute("msg", "Usuario no existe...!!!");

		         request.getRequestDispatcher("loginEmpleado.jsp").forward(request, response);
		}
	}

	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codemp, nombre,apellido,telefono,direccion,correo,usuario,clave;
		int idTipo;
		codemp=servicio.generaCodigo();
		nombre=request.getParameter("txt_nombre");
		apellido=request.getParameter("txt_apellido");
		telefono=request.getParameter("txt_telefono");
		direccion=request.getParameter("txt_direccion");
		correo=request.getParameter("txt_correo");
		usuario=request.getParameter("txt_usuario");
		clave=request.getParameter("txt_clave");
		
		idTipo=2;
	
		
		
		if(codemp.equals("")|| nombre.equals("")|| apellido.equals("")|| telefono.equals("")
				|| direccion.equals("")	|| correo.equals("")|| usuario.equals("")||clave.equals("")) {
			return;
		}
		
		
		
		
		
		EmpleadosDTO emp = new EmpleadosDTO();
		emp.setCodemp(codemp);
		emp.setNombre(nombre);
		emp.setApellido(apellido);
			emp.setUsuario(usuario);
		emp.setClave(clave);
		emp.setTelefono(telefono);
		emp.setDireccion(direccion);
		emp.setCorreo(correo);
	
		servicio.agregaEmpleado(emp);
		
		
		
	}
}
