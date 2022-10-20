package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UsuariosDTO;

import interfaces.UsuariosDAO;
import utils.MySqlDBConexion;


public class MySqlUsuariosDAO implements UsuariosDAO {

	@Override
	public UsuariosDTO iniciarSesion(String usu, String clave) {
		UsuariosDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			String sql="select * from tb_Usuario where usuario=? and clave=?";
			cn= MySqlDBConexion.getConexion();
			pstm= cn.prepareStatement(sql);
			pstm.setString(1, usu);
			pstm.setString(2, clave);
			rs= pstm.executeQuery();
			if(rs.next()) {
				obj = new UsuariosDTO();
				obj.setIdUsu(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setTelefono(rs.getString(4));
				obj.setDireccion(rs.getString(5));
				obj.setCorreo(rs.getString(6));
				obj.setIdTipoUsu(rs.getInt(7));
				obj.setUsuario(rs.getString(8));
				obj.setClave(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}

}
