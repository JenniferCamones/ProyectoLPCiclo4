package dao;

import interfaces.ProductoDAO;
import interfaces.ProveedorDAO;
import interfaces.ClienteDAO;
import interfaces.EmpleadoDAO;
import interfaces.LocalDAO;

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
	
	
	public LocalDAO getLocal() {
		// TODO Auto-generated method stub
		return new MySqlLocalDAO();
	}
	


	@Override
	public ProveedorDAO getProveedor() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}



	
	

}
