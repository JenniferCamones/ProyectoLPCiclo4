package MisServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteDTO;
import beans.EmpleadosDTO;
import beans.ProductoDTO;
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

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("cod");
		servicio.eliminaEmpleado(cod);
		listar(request, response);
	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod=request.getParameter("cod");
		
		request.setAttribute("Empleado", servicio.buscaEmpleado(cod));
		request.getRequestDispatcher("empleados.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nombre,apellidos,usuario,clave,telefono,direccion,correo;
		int tipo=3;
		
		nombre=request.getParameter("txt_nombre2");
		
		apellidos=request.getParameter("txt_apellido2");
		
		usuario=request.getParameter("txt_usuario2");
		
		clave=request.getParameter("txt_clave2");
		telefono=request.getParameter("txt_telefono2");
		direccion=request.getParameter("txt_direccion2");
		correo=request.getParameter("txt_correo2");
		cod=request.getParameter("txt_cod2");
		EmpleadosDTO emp=new EmpleadosDTO();
		
		
		emp.setNombre(nombre);
		emp.setApellido(apellidos);
		emp.setUsuario(usuario);
		emp.setClave(clave);
		emp.setTelefono(telefono);
		emp.setDireccion(direccion);
		emp.setCorreo(correo);
		emp.setCodemp(cod);
		emp.setIdTipo(tipo);
		
	
		servicio.actualizaEmpleado(emp);
		listar(request, response);
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
			usuario=request.getParameter("txt_usuario");
		clave=request.getParameter("txt_clave");
		telefono=request.getParameter("txt_telefono");
		direccion=request.getParameter("txt_direccion");
		correo=request.getParameter("txt_correo");
	
		
		idTipo=3;
	
		
		
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
		listar(request, response);
		
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data", servicio.listaEmpleado());
		((HttpServletRequest) request).getRequestDispatcher("listarEmpleados.jsp").forward(request, response); 
		
	}
	
}
