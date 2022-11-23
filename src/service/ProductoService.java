package service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import beans.ReporteVentas;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import utils.Constantes;

public class ProductoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ProductoDAO objPro = fabrica.getProducto();
	
	public List<ReporteVentas> listarVentasGeneral(Date fechaInicio,Date fechaFin) {
		return objPro.listarVentasGeneral(fechaInicio,fechaFin);
	}
	
	public List<ProductoDTO> listaProducto() {
		return objPro.listarProductos();
	}
	
	public int agregaProducto(ProductoDTO prod) {
		return objPro.agregarProducto(prod);
	}
	
	public int actualizaProducto(ProductoDTO prod) {
		return objPro.actualizarProducto(prod);
	}
	public String generaCodigo() {
		return objPro.generarCodigo();
	}
	

	
	public int eliminaProducto(String cod) {
		return objPro.eliminarProducto(cod);
	}
	
	public ProductoDTO buscaProducto(String cod) {
		return objPro.buscarProducto(cod);
	}
	public void listaImg(String cod,HttpServletResponse response) {
			objPro.listarImg(cod,response);
	}
	
	
}