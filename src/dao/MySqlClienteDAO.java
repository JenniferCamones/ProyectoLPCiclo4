package dao;

import java.util.List;
import beans.ClienteDTO;
import beans.EmpleadosDTO;
import interfaces.ClienteDAO;
import utils.MySqlDBConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MySqlClienteDAO implements ClienteDAO{
	
	 public List<ClienteDTO> listarCliente() {
		List<ClienteDTO> dt= new ArrayList<ClienteDTO>();
		ClienteDTO obj =null;
		Connection cn= null;
		PreparedStatement pstm= null;
		ResultSet rs= null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select idCliente,Nombre,Direccion,dni,telefono from Cliente ;";
		pstm = cn.prepareStatement(sql);	
			rs= pstm.executeQuery();
			while (rs.next()) {
				obj = new ClienteDTO();
				obj.setIdCliente(rs.getInt(0));
				obj.setNombre(rs.getString(1));
				obj.setDireccion(rs.getString(2));
				obj.setDni(rs.getString(3));
				obj.setTelefono(rs.getString(4));
				dt.add(obj);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}							
		return dt;
	}
	 public boolean insertarCliente(ClienteDTO c) {
			Connection cn = null;
			PreparedStatement pstm = null;
			Boolean rs = false;
					
			try {
				cn = MySqlDBConexion.getConexion();
				String sql = "insert into cliente(nombre,direccion,dni,telefono) value(?,?,?,?);";  					
				
				pstm = cn.prepareStatement(sql);
				
				pstm.setString(0, c.getNombre());
				pstm.setString(1, c.getDireccion());
				pstm.setString(2, c.getDni());
				pstm.setString(3, c.getTelefono());												
	          rs = pstm.execute();
													
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return rs;		
		}
	 public boolean actualizarCliente(ClienteDTO c) {
			Connection cn = null;
			PreparedStatement pstm = null;
			Boolean rs = false;
					
			try {
				cn = MySqlDBConexion.getConexion();
				String sql ="UPDATE cliente SET nombre=?,direccion=?,dni=?,telefono=? where idCliente =?; ";  					
				pstm = cn.prepareStatement(sql);
				pstm.setString(0, c.getNombre());
				pstm.setString(1, c.getDireccion());
				pstm.setString(2, c.getDni());
				pstm.setString(3, c.getTelefono());
				
	            pstm.executeUpdate();
					rs=true;								
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return rs;		
		
		}
	 public boolean eliminarCliente(int idCliente) {
			Connection cn = null;
			PreparedStatement pstm = null;
			Boolean rs = false;
			
			try {
				cn = MySqlDBConexion.getConexion();
				String sql ="update cliente set estado=0 where idCliente = ? ";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(0,idCliente);
				pstm.executeUpdate();
				rs=true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return rs;
		}
	 public boolean activarCliente(int idCliente) {
			Connection cn = null;
			PreparedStatement pstm = null;
			Boolean rs = false;
			
			try {
				cn = MySqlDBConexion.getConexion();
				String sql ="update cliente set estado=1 where idCliente = ? ";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(0,idCliente);
				pstm.executeUpdate();
				rs=true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return rs;
		}

	 
	 
	 
}
