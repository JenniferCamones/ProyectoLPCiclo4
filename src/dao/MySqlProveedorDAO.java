package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.EmpleadosDTO;
import beans.ProveedorDTO;
import utils.MySqlDBConexion;

public class MySqlProveedorDAO {

	public List<ProveedorDTO> listarProveedor() {
		List<ProveedorDTO> data = new ArrayList<ProveedorDTO>();
		ProveedorDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select idProveedor, nombre,direccion,correo,fechaRegistro,empleadoRegistro,fechaModifica,empleadoModifica from Proveedor";  

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new ProveedorDTO();
				obj.setIdProveedor(rs.getInt(0));
				obj.setNombre(rs.getString(1));
				obj.setDireccion(rs.getString(2));
				obj.setCorreo(rs.getString(3));
				obj.setFechaRegistro(rs.getString(4));
				obj.setUsuarioRegistro(rs.getInt(5));
				obj.setFechaModifica(rs.getString(6));
				obj.setUsuarioModifica(rs.getInt(7));
				data.add(obj);				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
	public boolean insertarProveedor(ProveedorDTO p) {
		Connection cn = null;
		PreparedStatement pstm = null;
		Boolean rs = false;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into Proveedor(nombre,direccion,correo,fechaRegistro,UsuarioRegistro) value(?,?,?,?,0);";  					
			pstm = cn.prepareStatement(sql);
	
			pstm.setString(0, p.getNombre());
			pstm.setString(1, p.getDireccion());
			pstm.setString(2, p.getCorreo());
			pstm.setString(3, p.getFechaRegistro());
			pstm.setInt(4, p.getUsuarioRegistro());
			pstm.setString(5, p.getFechaModifica());
			rs = pstm.execute();
												
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;		
	}
	public boolean actualizarProveedor(ProveedorDTO p) {
		Connection cn = null;
		PreparedStatement pstm = null;
		Boolean rs = false;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql ="UPDATE Proveedor SET nombre=?, direccion=?,correo=?,direccion=?,correo=?,fechaRegistro=?,usuarioRegistro=? where idProveedor =?; ";  					
			pstm = cn.prepareStatement(sql);
			pstm.setString(0, p.getNombre());
			pstm.setString(1, p.getDireccion());
			pstm.setString(2, p.getCorreo());
			pstm.setString(3, p.getFechaRegistro());
			pstm.setInt(4, p.getUsuarioRegistro());
			pstm.setString(5, p.getFechaModifica());
			
			
            pstm.executeUpdate();
				rs=true;								
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;		
	
	}
	public boolean eliminarProveedor(int idProveedor) {
		Connection cn = null;
		PreparedStatement pstm = null;
		Boolean rs = false;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql ="delete from Proveedor where idProveedor = ? ";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(0,idProveedor);
			pstm.executeUpdate();
			rs=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
	
}
