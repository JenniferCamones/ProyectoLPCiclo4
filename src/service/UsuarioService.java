package service;

import beans.UsuariosDTO;
import dao.DAOFactory;
import interfaces.UsuariosDAO;
import utils.Constantes;

public class UsuarioService {

	DAOFactory fa = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	UsuariosDAO objUsu = fa.getUsuarios();
	
	public UsuariosDTO iniciarSesion(String usu, String clave) {
		return objUsu.iniciarSesion(usu, clave);
	}
}
