package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.LocalDTO;
import beans.ProveedorDTO;
import interfaces.LocalDAO;
import utils.MySqlDBConexion;

public class MySqlLocalDAO implements LocalDAO {

	@Override
	public List<LocalDTO> listarLocales() {
		List<LocalDTO> data = new ArrayList<LocalDTO>();
		LocalDTO l = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select codLocal,departamento,distrito,direccion,telefono from tb_local";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				l = new LocalDTO();
				l.setCodLoc(rs.getString(1));
				l.setDepartamento(rs.getString(2));
				l.setDistrito(rs.getString(3));
				l.setDireccion(rs.getString(4));
				l.setTelefono(rs.getString(5));
				data.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int agregarLocal(LocalDTO l) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_local values (?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, l.getCodLoc());
			pstm.setString(2, l.getDepartamento());
			pstm.setString(3, l.getDistrito());
			pstm.setString(4, l.getDireccion());
				pstm.setString(5, l.getTelefono());
			
		
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
	public int actualizarLocal(LocalDTO l) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update tb_local set departamento=?, distrito=?,  direccion=?,telefono=?  where codLocal=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, l.getDepartamento());
			
			pstm.setString(2, l.getDistrito());
			pstm.setString(3, l.getDireccion());
			pstm.setString(4, l.getTelefono());
			pstm.setString(5, l.getCodLoc());
			estado = pstm.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarLocal(String idLocal) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_local where codLocal=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idLocal);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public String generarCodigo() {
		String codigo ="L0001";
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {			
			con=MySqlDBConexion.getConexion();
			
			String sql="select substring(max(codLocal),2) from tb_local";
			
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				codigo=String.format("L%04d",rs.getInt(1)+1);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
	
			System.out.println("Error en generar Codigo de Local");
		
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
	public LocalDTO buscarLocal(String cod) {
		// TODO Auto-generated method stub
		LocalDTO loc = null;
				Connection cn = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;
						
				try {
					cn = MySqlDBConexion.getConexion();
					String sql = "select * from tb_local where codLocal=?";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, cod);
					rs = pstm.executeQuery();
					if (rs.next()) {
						loc = new LocalDTO();
						loc.setCodLoc(rs.getString(1));
						loc.setDepartamento(rs.getString(2));
						loc.setDistrito(rs.getString(3));
						loc.setDireccion(rs.getString(4));
						loc.setTelefono(rs.getString(5));
						
				
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return loc;
	}

}
