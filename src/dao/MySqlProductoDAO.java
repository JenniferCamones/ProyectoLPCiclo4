package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySqlDBConexion;

public class MySqlProductoDAO implements ProductoDAO {
	
	@Override
	public List<ProductoDTO> listarProducto() {
		List<ProductoDTO> data = new ArrayList<ProductoDTO>();
		ProductoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String  sql = "select p.idProducto,p.nombre,p.stockActual,p.precioActual,p.fechaRegistro,p.empleadoRegistro,p.fechaModifica,p.empleadoModifica,cp.nombre_categoria from Producto inner join CategoriaProducto cp on p.idCategoriaProducto = cp.idCategoriaProducto";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new ProductoDTO();
				obj.setIdProducto(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setStockActual(rs.getInt(3));
				obj.setPrecioActual(rs.getDouble(4));
				obj.setFechaRegistro(rs.getString(5));
				obj.setEmpleadoRegistro(rs.getInt(6));
				obj.setFechaModifica(rs.getString(7));
				obj.setEmpleadoModifica(rs.getInt(8));
				obj.setNombre_cate(rs.getString(9));
				data.add(obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int registrarProducto(ProductoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into Producto values(null,?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getStockActual());
			pstm.setDouble(3, obj.getPrecioActual());
			pstm.setString(4, obj.getFechaRegistro());
			pstm.setInt(5, obj.getEmpleadoRegistro());
			pstm.setString(6, obj.getFechaModifica());
			pstm.setInt(7, obj.getEmpleadoModifica());
			pstm.setInt(8, obj.getIdCategoriaPro());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int actualizarProducto(ProductoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update Producto set nombre=?,stockActual=?,precioActual=?,fechaRegistro=?,empleadoRegistro=?,fechaModifica=?,empleadoModifica=?,idCategoriaProducto=? where idProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getStockActual());
			pstm.setDouble(3, obj.getPrecioActual());
			pstm.setString(4, obj.getFechaRegistro());
			pstm.setInt(5, obj.getEmpleadoRegistro());
			pstm.setString(6, obj.getFechaModifica());
			pstm.setInt(7, obj.getEmpleadoModifica());
			pstm.setInt(8, obj.getIdCategoriaPro());
			pstm.setInt(9, obj.getIdProducto());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarProducto(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from Producto where idProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public ProductoDTO buscarProducto(int cod) {
		ProductoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String  sql = "select * from Producto where idProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new ProductoDTO();
				obj.setIdProducto(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setStockActual(rs.getInt(3));
				obj.setPrecioActual(rs.getDouble(4));
				obj.setFechaRegistro(rs.getString(5));
				obj.setEmpleadoRegistro(rs.getInt(6));
				obj.setFechaModifica(rs.getString(7));
				obj.setEmpleadoModifica(rs.getInt(8));
				obj.setIdCategoriaPro(rs.getInt(9));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
