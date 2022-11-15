package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.EmpleadosDTO;
import beans.ProveedorDTO;
import interfaces.ProveedorDAO;
import utils.MySqlDBConexion;

public class MySqlProveedorDAO implements ProveedorDAO {

	@Override
	public List<ProveedorDTO> listarProveedores() {
		List<ProveedorDTO> data = new ArrayList<ProveedorDTO>();
		ProveedorDTO prov = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select codProveedor,nombre,direccion,correo from tb_proveedor";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				prov = new ProveedorDTO();
				prov.setCodProv(rs.getString(1));
				prov.setNombre(rs.getString(2));
				prov.setDireccion(rs.getString(3));
			
				prov.setCorreo(rs.getString(4));
				data.add(prov);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int agregarProveedor(ProveedorDTO pr) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_proveedor values (?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, pr.getCodProv());
			pstm.setString(2, pr.getNombre());
			
		
			pstm.setString(3, pr.getDireccion());
				pstm.setString(4, pr.getCorreo());
			
		
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
	public int actualizarProveedor(ProveedorDTO pr) {
		// TODO Auto-generated method stub
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update tb_proveedor set nombre=?, direccion=?,  correo=?  where codProveedor=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, pr.getNombre());
			
			pstm.setString(2, pr.getDireccion());
			pstm.setString(3, pr.getCorreo());
			pstm.setString(4, pr.getCodProv());
		
			estado = pstm.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarProveedor(String idProveedor) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_proveedor where codProveedor=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idProveedor);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public String generarCodigo() {

		String codigo ="PR0001";
				
				Connection con=null;
				PreparedStatement pst=null;
				ResultSet rs=null;
				
				try {			
					con=MySqlDBConexion.getConexion();
					
					String sql="select substring(max(codProveedor),3) from tb_proveedor";
					
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					if(rs.next()) {
						codigo=String.format("PR%04d",rs.getInt(1)+1);
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
			
					System.out.println("Error en generar Codigo de Proveedor");
				
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
	public ProveedorDTO buscarProveedor(String cod) {
		// TODO Auto-generated method stub
		ProveedorDTO prov = null;
				Connection cn = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;
						
				try {
					cn = MySqlDBConexion.getConexion();
					String sql = "select * from tb_proveedor where codProveedor=?";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, cod);
					rs = pstm.executeQuery();
					if (rs.next()) {
						prov = new ProveedorDTO();
						prov.setCodProv(rs.getString(1));
						prov.setNombre(rs.getString(2));
						
						prov.setDireccion(rs.getString(3));
						prov.setCorreo(rs.getString(4));
						
				
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return prov;
	}

	
	
	
}
