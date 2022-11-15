package interfaces;

import java.util.List;

import beans.EmpleadosDTO;
import beans.ProveedorDTO;

public interface ProveedorDAO {
	public List<ProveedorDTO> listarProveedores();
	public int agregarProveedor(ProveedorDTO pr);
	public int actualizarProveedor(ProveedorDTO pr);
	public int  eliminarProveedor(String idProveedor) ;
	public String generarCodigo();
	public ProveedorDTO buscarProveedor(String cod);

}
