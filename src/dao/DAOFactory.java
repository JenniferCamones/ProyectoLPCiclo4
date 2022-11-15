package dao;

import interfaces.ClienteDAO;
import interfaces.EmpleadoDAO;
import interfaces.LocalDAO;
import interfaces.ProductoDAO;
import interfaces.ProveedorDAO;

public abstract class DAOFactory {

	//Posibles origenes de Datos
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;
	
	//Se pone tantas interfaces como tengas
	
	public abstract ClienteDAO getCliente();
	public abstract ProductoDAO getProducto();
	public abstract EmpleadoDAO getEmpleado();
	public abstract ProveedorDAO getProveedor();
	public abstract LocalDAO getLocal();
	
	

	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch(whichFactory) {
			case MYSQL:
				return new MySqlDAOFactory();
			case ORACLE:
				//return new OracleDAOFactory();
			case SQLSERVER:
				//return new SQL ServerDAOFactory();
		}
		return null;
	}
	
}
