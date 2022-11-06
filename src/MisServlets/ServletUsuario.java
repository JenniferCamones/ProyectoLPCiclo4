package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuariosDTO;
import service.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	UsuarioService serviUsuario = new UsuarioService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
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
		String usu, clave;
		usu= request.getParameter("txtUsuario");
		clave= request.getParameter("txtClave");
		
		UsuariosDTO u=serviUsuario.iniciarSesion(usu, clave);
		
		
		if (u == null)
		{
			request.setAttribute("msj", "Error usuario y/o clave");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			if(u.getIdTipoUsu() == 1) {
				response.sendRedirect("producto.jsp");
			}else {
				response.sendRedirect("base.jsp");
			}
		}
	}

}
