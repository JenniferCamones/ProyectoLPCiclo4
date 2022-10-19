package service;

import java.util.List;

import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import utils.Constantes;

public class ProductoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ProductoDAO objPro = fabrica.getProducto();
	
	public List<ProductoDTO> listarProducto() {
		return objPro.listarProducto();
	}
	
	public ProductoDTO buscarProducto(int cod) {
		return objPro.buscarProducto(cod);
	}
	
	public int registrarProducto(ProductoDTO obj) {
		return objPro.registrarProducto(obj);
	}
	
	public int actualizarProducto(ProductoDTO obj) {
		return objPro.actualizarProducto(obj);
	}
	
	public int eliminarProducto(int cod) {
		return objPro.eliminarProducto(cod);
	}
	
}