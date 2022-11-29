package interfaces;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import beans.ReporteVentas;

public interface ProductoDAO {

	public List<ProductoDTO> listarProductos();
	public int agregarProducto(ProductoDTO p);
	public int actualizarProducto(ProductoDTO p);
	public int  eliminarProducto(String idProducto) ;
	public String generarCodigo();
	public ProductoDTO buscarProducto(String cod);
	public void listarImg(String cod,HttpServletResponse response);
	public List<ReporteVentas> listarVentasGeneral(Date fechaInicio,Date fechaFin);
	public List<ReporteVentas> listarVentasDetalle(Date fechaInicio,Date fechaFin);
}
