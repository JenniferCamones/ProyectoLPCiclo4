package interfaces;

import java.util.List;

import beans.EmpleadosDTO;

public interface EmpleadoDAO {

	public List<EmpleadosDTO> listarEmpleados();
	public int agregarEmpleado(EmpleadosDTO e);
	public int actualizarEmpleado(EmpleadosDTO e);
	public int  eliminarEmpleado(String idEmpleado) ;
	public String generarCodigo();
	public EmpleadosDTO buscarEmpleado(String cod);
	public EmpleadosDTO iniciarSesion(String login);
	
}
