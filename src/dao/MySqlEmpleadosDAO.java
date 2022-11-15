package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.EmpleadosDTO;
import beans.ProductoDTO;
import interfaces.EmpleadoDAO;
import utils.MySqlDBConexion;

public class MySqlEmpleadosDAO implements EmpleadoDAO{
		

    
	
	//select codEmpleado,nombre,apellidos,telefono,direccion,correo from tb_empleado;
	@Override
	public List<EmpleadosDTO> listarEmpleados() {
		List<EmpleadosDTO> data = new ArrayList<EmpleadosDTO>();
		EmpleadosDTO emp = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select codEmpleado,nombre,apellidos,telefono,direccion,correo from tb_empleado";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				emp = new EmpleadosDTO();
				emp.setCodemp(rs.getString(1));
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
	public int agregarEmpleado(EmpleadosDTO e) {
		// TODO Auto-generated method stub
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_empleado values (?,?,?,?,?,?, ?,?,default)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, e.getCodemp());
			pstm.setString(2, e.getNombre());
			pstm.setString(3, e.getApellido());
			pstm.setString(4, e.getUsuario());
			pstm.setString(5, e.getClave());
			pstm.setString(6, e.getTelefono());
			pstm.setString(7, e.getDireccion());
				pstm.setString(8, e.getCorreo());
			
		
			estado = pstm.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
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
	public int actualizarEmpleado(EmpleadosDTO e) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update tb_empleado set nombre=?, apellidos=?,  usuario=?, contraseña=?, telefono=?,direccion=?,correo=? where codEmpleado=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getApellido());
			pstm.setString(3, e.getUsuario());
			pstm.setString(4, e.getClave());
			pstm.setString(5, e.getTelefono());
			pstm.setString(6, e.getDireccion());
			pstm.setString(7, e.getCorreo());
			pstm.setString(8, e.getCodemp());
		
			estado = pstm.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return estado;
	}
	@Override
	public int eliminarEmpleado(String idEmpleado) {
		// TODO Auto-generated method stub
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_empleado where codEmpleado=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idEmpleado);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}
	@Override
	public String generarCodigo() {
		// TODO Auto-generated method stub
		
		String codigo ="E0001";
				
				Connection con=null;
				PreparedStatement pst=null;
				ResultSet rs=null;
				
				try {			
					con=MySqlDBConexion.getConexion();
					
					String sql="select substring(max(codEmpleado),2) from tb_empleado";
					
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					if(rs.next()) {
						codigo=String.format("E%04d",rs.getInt(1)+1);
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
			
					System.out.println("Error en generar Codigo de Empleado");
				
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
	public EmpleadosDTO buscarEmpleado(String cod) {
		// TODO Auto-generated method stub
		EmpleadosDTO emp = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_empleado where codEmpleado=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				emp = new EmpleadosDTO();
				emp.setCodemp(rs.getString(1));
				emp.setNombre(rs.getString(2));
				emp.setApellido(rs.getString(3));
				emp.setUsuario(rs.getString(4));
				emp.setClave(rs.getString(5));
				emp.setTelefono(rs.getString(6));
				emp.setDireccion(rs.getString(7));
				emp.setCorreo(rs.getString(8));
				
		
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	@Override
	public EmpleadosDTO iniciarSesion(String login) {
		// TODO Auto-generated method stub
		EmpleadosDTO emp=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			
			cn=MySqlDBConexion.getConexion();
			String sql="select * from tb_empleado where usuario=?";
			pstm= cn.prepareStatement(sql);
			pstm.setString(1,login);
			rs=pstm.executeQuery();
			if(rs.next()) {
				  emp = new EmpleadosDTO();

				  emp.setCodemp(rs.getString(1));

				  emp.setNombre(rs.getString(2));

				  emp.setApellido(rs.getString(3));
				  emp.setUsuario(rs.getString(4));

				  emp.setClave(rs.getString(5));
				  
				  emp.setTelefono(rs.getString(6));
				  emp.setDireccion(rs.getString(7));
				  emp.setCorreo(rs.getString(8));
				

				  
				  emp.setIdTipo(rs.getInt(9));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		       e.printStackTrace();
		}
		
		return emp;
	}


}
