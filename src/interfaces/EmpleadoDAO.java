package interfaces;

import java.util.List;

import beans.EmpleadosDTO;

public interface EmpleadoDAO {

	public List<EmpleadosDTO> listarEmpleados();
	public int agregarEmpleado(EmpleadosDTO e);
	public int actualizarEmpleado(EmpleadosDTO e);
	public int  eliminarEmpleado(int idEmpleado) ;
	public String generarCodigo();
	public EmpleadosDTO buscarEmpleado(int cod);
	public EmpleadosDTO iniciarSesion(String login);
	
}
