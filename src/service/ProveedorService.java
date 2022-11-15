package service;

import java.util.List;

import beans.EmpleadosDTO;
import beans.ProveedorDTO;
import dao.DAOFactory;
import interfaces.EmpleadoDAO;
import interfaces.ProveedorDAO;
import utils.Constantes;

public class ProveedorService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ProveedorDAO objProv = fabrica.getProveedor();
	
	public List<ProveedorDTO> listaProveedor() {
		return objProv.listarProveedores();
	}
	
	public int agregaProveedor(ProveedorDTO prov) {
		return objProv.agregarProveedor(prov);
	}
	
	public int actualizaProveedor(ProveedorDTO prov) {
		return objProv.actualizarProveedor(prov);
	}
	public String generaCodigo() {
		return objProv.generarCodigo();
	}
	

	
	public int eliminaProveedor(String cod) {
		return objProv.eliminarProveedor(cod);
	}
	
	public ProveedorDTO buscaProveedor(String cod) {
		return objProv.buscarProveedor(cod);
	}
	
}
