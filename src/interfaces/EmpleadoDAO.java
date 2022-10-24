package interfaces;

import java.util.List;

import beans.EmpleadosDTO;

public interface EmpleadoDAO {

	public List<EmpleadosDTO> listarEmpleados();
	public boolean insertarEmpleado(EmpleadosDTO e);
	public boolean actualizarEmpleado(EmpleadosDTO e);
	public boolean eliminarEmpleado(int idEmpleado) ;
	public boolean activarEmpleado(int idEmpleado);
}
