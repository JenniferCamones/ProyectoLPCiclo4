package service;

import java.util.List;

import beans.ClienteDTO;
import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ClienteDAO;
import interfaces.ProductoDAO;
import utils.Constantes;

public class ClienteService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ClienteDAO objCli = fabrica.getCliente();
	
	public int agregaCliente(ClienteDTO cli) {
		return objCli.agregarCliente(cli);
	}
	
	
	public String generaCodigo() {
		return objCli.generarCodigo();
	}
	
	
	
	
	
	
}
