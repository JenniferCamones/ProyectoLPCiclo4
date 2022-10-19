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
			String  sql = "select * from Producto";
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarProducto(ProductoDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarProducto(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductoDTO buscarProducto(int cod) {
		// TODO Auto-generated method stub
		return null;
	}
}
