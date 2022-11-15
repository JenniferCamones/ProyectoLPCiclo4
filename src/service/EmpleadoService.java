package service;

import java.util.List;


import beans.EmpleadosDTO;

import dao.DAOFactory;

import interfaces.EmpleadoDAO;
import utils.Constantes;

public class EmpleadoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	EmpleadoDAO objEmp = fabrica.getEmpleado();
	
	public List<EmpleadosDTO> listaEmpleado() {
		return objEmp.listarEmpleados();
	}
	
	public int agregaEmpleado(EmpleadosDTO emp) {
		return objEmp.agregarEmpleado(emp);
	}
	
	public int actualizaEmpleado(EmpleadosDTO emp) {
		return objEmp.actualizarEmpleado(emp);
	}
	public String generaCodigo() {
		return objEmp.generarCodigo();
	}
	
	public EmpleadosDTO iniciaSesion(String login) {
		return objEmp.iniciarSesion(login);
	}
	
	public int eliminaEmpleado(String cod) {
		return objEmp.eliminarEmpleado(cod);
	}
	
	public EmpleadosDTO buscaEmpleado(String cod) {
		return objEmp.buscarEmpleado(cod);
	}
	
	
	
	
	
}
