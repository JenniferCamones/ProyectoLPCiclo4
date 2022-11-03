package interfaces;

import java.util.List;

import beans.ProveedorDTO;

public interface ProveedorDAO {
	public List<ProveedorDTO> listarProveedor();
	public boolean insertarProveedor(ProveedorDTO p);
	public boolean actualizarProveedor(ProveedorDTO p);
	public boolean eliminarProveedor(int idProveedor);
	
}
