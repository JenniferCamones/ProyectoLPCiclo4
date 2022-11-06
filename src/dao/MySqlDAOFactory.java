package dao;

import interfaces.ProductoDAO;
import interfaces.EmpleadoDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public ProductoDAO getProducto() {
		return new MySqlProductoDAO();
	}
	public EmpleadoDAO getEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	//PARA USUARIOS
	@Override
	public MySqlUsuariosDAO getUsuarios() {
		
		return new MySqlUsuariosDAO();
	}
	
	

}
