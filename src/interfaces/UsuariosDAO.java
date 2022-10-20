package interfaces;

import beans.UsuariosDTO;

public interface UsuariosDAO {

	public UsuariosDTO iniciarSesion(String usu, String clave);
}
