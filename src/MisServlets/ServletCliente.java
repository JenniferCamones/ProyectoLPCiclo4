package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteDTO;


import service.ClienteService;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteService servicio=new ClienteService();
    /**
     * Default constructor. 
     */
    public ServletCliente() {
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
		else if (xtipo.equals("eliminar")) {
			eliminar(request, response);
		}
		if (xtipo.equals("listar")) {
			listar(request, response);
		}
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("cod");
		servicio.eliminaCliente(cod);
		listar(request, response);
	}
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data", servicio.listaCliente());
		((HttpServletRequest) request).getRequestDispatcher("listarClientes.jsp").forward(request, response); 
		
	}


	private void CerrarSesion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession();
		sesion.invalidate();
	      request.setAttribute("msg", "Iniciar Sesion");

	         request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xlogin=request.getParameter("txt_login");
		String xclave=request.getParameter("txt_clave");
		System.out.println("Login:  "+xlogin); 
		System.out.println("Clave:  "+xclave);	
		
		ClienteDTO obj=servicio.iniciaSesion(xlogin);
		if(obj !=null) {
			if(obj.getClave().equals(xclave)) {
				HttpSession sesion=request.getSession();
				sesion.setAttribute("datos",obj);
				request.getRequestDispatcher("inicioUsuario.jsp").forward(request,response);
			}else {
				request.setAttribute("msg","Contrase??a Incorrecta");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}else {
		       request.setAttribute("msg", "Usuario no existe...!!!");

		         request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codcli, nombre,apellido,telefono,direccion,correo,usuario,clave,repassword;
		int idTipo;
		codcli=servicio.generaCodigo();
		nombre=request.getParameter("txt_nombre");
		apellido=request.getParameter("txt_apellido");
		telefono=request.getParameter("txt_telefono");
		direccion=request.getParameter("txt_direccion");
		correo=request.getParameter("txt_correo");
		usuario=request.getParameter("txt_usuario");
		clave=request.getParameter("txt_clave");
		repassword=request.getParameter("txt_repassword");
		idTipo=2;
	
		
		
		if(codcli.equals("")|| nombre.equals("")|| apellido.equals("")|| telefono.equals("")
				|| direccion.equals("")	|| correo.equals("")|| usuario.equals("")||clave.equals("")||repassword.equals("")) {
			return;
		}
		if(!clave.equals(repassword)) {
			return;
		}
		
		
		
		if(  clave.equals(repassword)) {
			ClienteDTO cli = new ClienteDTO();
		cli.setCodcli(codcli);
		cli.setNombre(nombre);
		cli.setApellido(apellido);
		cli.setTelefono(telefono);
		cli.setDireccion(direccion);
		cli.setCorreo(correo);
		cli.setUsuario(usuario);
		cli.setClave(clave);
		servicio.agregaCliente(cli);
		request.getRequestDispatcher("register.jsp").forward(request, response);
		}else {
			return;
		}
		
		
		
	}



}
