package dao;

import java.util.List;
import beans.ClienteDTO;
import beans.EmpleadosDTO;
import beans.ProductoDTO;
import interfaces.ClienteDAO;
import utils.MySqlDBConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MySqlClienteDAO implements ClienteDAO{
	/*
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
		*/
	 public int actualizarCliente(ClienteDTO c) {
			Connection cn = null;
			PreparedStatement pstm = null;
			int rs = -1;
					
			try {
				cn = MySqlDBConexion.getConexion();
				String sql ="UPDATE cliente SET nombre=?,direccion=?,dni=?,telefono=? where idCliente =?; ";  					
				pstm = cn.prepareStatement(sql);
				pstm.setString(0, c.getNombre());
				pstm.setString(1, c.getDireccion());
			
				pstm.setString(3, c.getTelefono());
				
	            pstm.executeUpdate();
					rs=1;								
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			return rs;		
		
		}
	 /*
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
		*/
	 /*
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
		*/

	@Override
	public List<ClienteDTO> listarCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int agregarCliente(ClienteDTO c) {
		// TODO Auto-generated method stub
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_cliente values(?,?,?,?,?,?,?,?,default)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, c.getCodcli());
			pstm.setString(2, c.getNombre());
			pstm.setString(3, c.getApellido());
			pstm.setString(4, c.getTelefono());
			pstm.setString(5, c.getDireccion());
				pstm.setString(6, c.getCorreo());
			pstm.setString(7, c.getUsuario());
			pstm.setString(8, c.getClave());
		
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar");
			}
		}
		return estado;
	}

	@Override
	public int eliminarCliente(int idCliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String generarCodigo() {
		
String codigo ="C0001";
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {			
			con=MySqlDBConexion.getConexion();
			
			String sql="select substring(max(codCliente),2) from tb_cliente";
			
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				codigo=String.format("C%04d",rs.getInt(1)+1);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
	
			System.out.println("Error en generar Codigo de Cliente");
		
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
			
				System.out.println("Error al cerrar: "+e.getMessage());
				
			}
		}
		
		return codigo;
		
	}

	@Override
	public ProductoDTO buscarCliente(int cod) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 /*
	@Override
	public List<ClienteDTO> listarCliente() {
		// TODO Auto-generated method stub
		return null;
		
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_producto values(null,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setDouble(2, obj.getPrecio());
			pstm.setInt(3, obj.getStock());
			pstm.setInt(4, obj.getCodMarca());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
		
	}
	
	 */
	 
	 
}
