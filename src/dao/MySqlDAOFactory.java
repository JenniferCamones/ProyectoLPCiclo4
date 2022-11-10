package dao;

import interfaces.ProductoDAO;
import interfaces.ClienteDAO;
import interfaces.EmpleadoDAO;

public class MySqlDAOFactory extends DAOFactory {
	
	
	
	@Override
	public ClienteDAO getCliente() {
		// TODO Auto-generated method stub
		return new MySqlClienteDAO();
	}
	
	
	@Override
	public ProductoDAO getProducto() {
		return new MySqlProductoDAO();
	}
	public EmpleadoDAO getEmpleado() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadosDAO();
	}
	
	

	//PARA USUARIOS
	@Override
	public MySqlUsuariosDAO getUsuarios() {
		
		return new MySqlUsuariosDAO();
	}

	
	

}
