package interfaces;

import java.util.List;

import beans.ClienteDTO;

import beans.ProductoDTO;

public interface ClienteDAO {
	 public List<ClienteDTO> listarCliente();
	 public int agregarCliente(ClienteDTO c);
	 public int actualizarCliente(ClienteDTO c);
	 public int eliminarCliente(String idCliente);
	 public String generarCodigo();
	 public ClienteDTO buscarCliente(int cod);
	 
	 public ClienteDTO iniciarSesion(String login);
		
	 
	 
	 
	 
	 
}
