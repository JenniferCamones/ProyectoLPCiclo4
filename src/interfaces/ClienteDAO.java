package interfaces;

import java.util.List;

import beans.ClienteDTO;

public interface ClienteDAO {
	 public List<ClienteDTO> listarCliente();
	 public boolean insertarCliente(ClienteDTO c);
	 public boolean actualizarCliente(ClienteDTO c);
	 public boolean eliminarCliente(int idCliente);
	 public boolean activarCliente(int idCliente);
}
