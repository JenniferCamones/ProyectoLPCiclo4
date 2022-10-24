package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.EmpleadosDTO;
import interfaces.EmpleadoDAO;
import utils.MySqlDBConexion;

public class MySqlEmpleadosDAO implements EmpleadoDAO{
		
	public List<EmpleadosDTO> listarEmpleados() {
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
		
	}
    public boolean insertarEmpleado(EmpleadosDTO e) {
		Connection cn = null;
		PreparedStatement pstm = null;
		Boolean rs = false;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into empleado(nombre,apellidos,telefono,direccion,correo,idTipoEmpleado,estado) value(?,?,?,?,?,?,1);";  					
			pstm = cn.prepareStatement(sql);
			pstm.setString(0, e.getNombre());
			pstm.setString(1, e.getApellidos());
			pstm.setString(2, e.getTelefono());
			pstm.setString(3, e.getDireccion());
			pstm.setString(4, e.getCorreo());
			pstm.setInt(5, e.getIdTipoEmpleado());
          rs = pstm.execute();
												
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;		
	}
	public boolean actualizarEmpleado(EmpleadosDTO e) {
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
	
	}
	public boolean eliminarEmpleado(int idEmpleado) {
		Connection cn = null;
		PreparedStatement pstm = null;
		Boolean rs = false;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql ="update empleado set estado=0 where idEmpleado = ? ";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(0,idEmpleado);
			pstm.executeUpdate();
			rs=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public boolean activarEmpleado(int idEmpleado) {
		Connection cn = null;
		PreparedStatement pstm = null;
		Boolean rs = false;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql ="update empleado set estado=1 where idEmpleado = ? ";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(0,idEmpleado);
			pstm.executeUpdate();
			rs=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

}
