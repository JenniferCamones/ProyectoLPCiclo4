package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import service.ProductoService;
/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService serviProducto = new ProductoService(); 
       
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
		if (xtipo.equals("listar")) {
			listar(request,response);
		}
		else if (xtipo.equals("actualizar")) {
			actualizar(request,response);
		}
		else if (xtipo.equals("registrar")) {
			registrar(request,response);
		}
		else if (xtipo.equals("eliminar")) {
			eliminar(request,response);
		}
		else if (xtipo.equals("buscar")) {
			buscar(request,response);
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Producto", serviProducto.buscarProducto(cod));
		request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
	}
 
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviProducto.eliminarProducto(cod);
		listar(request, response);
	}
 
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stock,empreg,empmod,categoria;
		String nom = request.getParameter("txt_nom");
		stock = Integer.parseInt(request.getParameter("txt_stock"));
		double pre = Double.parseDouble(request.getParameter("txt_pre"));
		String fech_reg = request.getParameter("txt_fec_reg");
		empreg= Integer.parseInt(request.getParameter("txt_emp_reg"));
		String fech_mod = request.getParameter("txt_fec_mod");
		empmod= Integer.parseInt(request.getParameter("txt_emp_mod"));
		categoria= Integer.parseInt(request.getParameter("cbo_cate"));
		ProductoDTO obj = new ProductoDTO();
		obj.setNombre(nom);
		obj.setStockActual(stock);
		obj.setPrecioActual(pre);
		obj.setFechaRegistro(fech_reg);
		obj.setEmpleadoRegistro(empreg);
		obj.setFechaModifica(fech_mod);
		obj.setEmpleadoModifica(empmod);
		obj.setIdCategoriaPro(categoria);
		serviProducto.registrarProducto(obj);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id,stock,empreg,empmod,categoria;
		id = Integer.parseInt(request.getParameter("txt_id"));
		String nom = request.getParameter("txt_nom");
		stock = Integer.parseInt(request.getParameter("txt_stock"));
		double pre = Double.parseDouble(request.getParameter("txt_pre"));
		String fech_reg = request.getParameter("txt_fec_reg");
		empreg= Integer.parseInt(request.getParameter("txt_emp_reg"));
		String fech_mod = request.getParameter("txt_fec_mod");
		empmod= Integer.parseInt(request.getParameter("txt_emp_mod"));
		categoria= Integer.parseInt(request.getParameter("cbo_cate"));
		ProductoDTO obj = new ProductoDTO();
		obj.setIdProducto(id);
		obj.setNombre(nom);
		obj.setStockActual(stock);
		obj.setPrecioActual(pre);
		obj.setFechaRegistro(fech_reg);
		obj.setEmpleadoRegistro(empreg);
		obj.setFechaModifica(fech_mod);
		obj.setEmpleadoModifica(empmod);
		obj.setIdCategoriaPro(categoria);
		serviProducto.actualizarProducto(obj);
		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviProducto.listarProducto());
		request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	}

}
