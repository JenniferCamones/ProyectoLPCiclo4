package service;

import java.util.List;

import beans.LocalDTO;
import beans.ProveedorDTO;
import dao.DAOFactory;
import interfaces.LocalDAO;
import interfaces.ProveedorDAO;
import utils.Constantes;

public class LocalService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	LocalDAO objLoc = fabrica.getLocal();
	
	public List<LocalDTO> listaLocal() {
		return objLoc.listarLocales();
	}
	
	public int agregaLocal(LocalDTO loc) {
		return objLoc.agregarLocal(loc);
	}
	
	public int actualizaLocal(LocalDTO loc) {
		return objLoc.actualizarLocal(loc);
	}
	public String generaCodigo() {
		return objLoc.generarCodigo();
	}
	

	
	public int eliminaLocal(String cod) {
		return objLoc.eliminarLocal(cod);
	}
	
	public LocalDTO buscaLocal(String cod) {
		return objLoc.buscarLocal(cod);
	}
	
	
	
	
}
