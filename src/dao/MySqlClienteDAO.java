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
	
	@Override
	public List<ClienteDTO> listarCliente() {
		List<ClienteDTO> data = new ArrayList<ClienteDTO>();
		ClienteDTO emp = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select codCliente,nombre,apellido,telefono,direccion,correo from tb_cliente";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				emp = new ClienteDTO();
				emp.setCodcli(rs.getString(1));
				emp.setNombre(rs.getString(2));
				emp.setApellido(rs.getString(3));
				emp.setTelefono(rs.getString(4));
				emp.setDireccion(rs.getString(5));
				emp.setCorreo(rs.getString(6));
				data.add(emp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
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
	public int eliminarCliente(String idCliente) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_cliente where codCliente=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idCliente);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
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
	public ClienteDTO buscarCliente(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDTO iniciarSesion(String login) {
		ClienteDTO cli=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			
			cn=MySqlDBConexion.getConexion();
			String sql="select * from tb_cliente where usuario=?";
			pstm= cn.prepareStatement(sql);
			pstm.setString(1,login);
			rs=pstm.executeQuery();
			if(rs.next()) {
				  cli = new ClienteDTO();

				  cli.setCodcli(rs.getString(1));

				  cli.setNombre(rs.getString(2));

				  cli.setApellido(rs.getString(3));
				  cli.setTelefono(rs.getString(4));
				  cli.setDireccion(rs.getString(5));
				  cli.setCorreo(rs.getString(6));
				

				  cli.setUsuario(rs.getString(7));

				  cli.setClave(rs.getString(8));
				  cli.setIdTipo(rs.getInt(9));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		       e.printStackTrace();
		}
		
		return cli;
	}



	@Override
	public int actualizarCliente(ClienteDTO c) {
		// TODO Auto-generated method stub
		return 0;
	}
	 
	
	 
}
