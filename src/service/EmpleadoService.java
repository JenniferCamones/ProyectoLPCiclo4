package service;

import beans.ClienteDTO;
import beans.EmpleadosDTO;
import dao.DAOFactory;
import interfaces.ClienteDAO;
import interfaces.EmpleadoDAO;
import utils.Constantes;

public class EmpleadoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	EmpleadoDAO objEmp = fabrica.getEmpleado();
	
	public int agregaEmpleado(EmpleadosDTO emp) {
		return objEmp.agregarEmpleado(emp);
	}
	
	
	public String generaCodigo() {
		return objEmp.generarCodigo();
	}
	
	public EmpleadosDTO iniciaSesion(String login) {
		return objEmp.iniciarSesion(login);
	}
	
	
}
