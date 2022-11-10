package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ClienteDTO;
import beans.EmpleadosDTO;
import interfaces.EmpleadoDAO;
import utils.MySqlDBConexion;

public class MySqlEmpleadosDAO implements EmpleadoDAO{
		
	/*public List<EmpleadosDTO> listarEmpleados() {
		List<EmpleadosDTO> data = new ArrayList<EmpleadosDTO>();
		EmpleadosDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select idEmpleado, nombre,apellidos,telefono,direccion,correo,idTipoEmpleado,estado from Empleado";  
					
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new EmpleadosDTO();
				obj.setIdEmpleado(rs.getInt(0));
				obj.setNombre(rs.getString(1));
				obj.setApellidos(rs.getString(2));
				obj.setTelefono(rs.getString(3));
				obj.setDireccion(rs.getString(4));
				obj.setCorreo(rs.getString(5));
				obj.setIdTipoEmpleado(rs.getInt(6));
				obj.setEstado(rs.getBoolean(7));
				data.add(obj);				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}*/
    
	/*public boolean actualizarEmpleado(EmpleadosDTO e) {
		Connection cn = null;
		PreparedStatement pstm = null;
		Boolean rs = false;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql ="UPDATE Empleado SET nombre=?, apellidos=?,telefono=?,direccion=?,correo=?,idTipoEmpleado=? where idEmpleado =?; ";  					
			pstm = cn.prepareStatement(sql);
			pstm.setString(0, e.getNombre());
			pstm.setString(1, e.getApellidos());
			pstm.setString(2, e.getTelefono());
			pstm.setString(3, e.getDireccion());
			pstm.setString(4, e.getCorreo());
			pstm.setInt(5, e.getIdTipoEmpleado());
			pstm.setInt(6, e.getIdEmpleado());
			
            pstm.executeUpdate();
				rs=true;								
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;		
	
	}*/
	
	@Override
	public List<EmpleadosDTO> listarEmpleados() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int eliminarEmpleado(int idEmpleado) {
		// TODO Auto-generated method stub
		return 0;
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
	public EmpleadosDTO buscarEmpleado(int cod) {
		// TODO Auto-generated method stub
		return null;
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
