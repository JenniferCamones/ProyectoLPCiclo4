package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Blob;

import beans.ProductoDTO;
import beans.ReporteVentas;
import interfaces.ProductoDAO;
import utils.MySqlDBConexion;

public class MySqlProductoDAO implements ProductoDAO {

	
	public List<ReporteVentas> listarVentasGeneral(Date fechaInicio,Date fechaFin) {
		List<ReporteVentas> data = new ArrayList<ReporteVentas>();
		ReporteVentas p = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "CALL sp_reporteVentasGeneral(?,?)";
			pstm = cn.prepareCall(sql);
			pstm.setString(1, new SimpleDateFormat("yyyy/MM/dd").format(fechaInicio));
			pstm.setString(2,new SimpleDateFormat("yyyy/MM/dd").format(fechaFin));
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				p = new ReporteVentas
						(rs.getString(1),rs.getDate(2),rs.getString(3),
						 rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7));
				data.add(p);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	@Override
	public List<ProductoDTO> listarProductos() {
		List<ProductoDTO> data = new ArrayList<ProductoDTO>();
		ProductoDTO p = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select p.codProducto,p.imagen,p.nombre,cp.nom_cat,p.descripcion,p.stock,p.precio,p.fechaRegistro from tb_producto p inner join tb_categoriaProducto cp on p.idCategoriaProducto=cp.idCategoriaProducto";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				p = new ProductoDTO();
				p.setCodProducto(rs.getString(1));
				p.setImagen(rs.getBinaryStream(2));
				p.setNombre(rs.getString(3));
				p.setCategoria(rs.getString(4));
				p.setDescripcion(rs.getString(5));
				p.setStock(rs.getInt(6));
				p.setPrecio(rs.getDouble(7));
				p.setFechaRegistro(rs.getString(8));
				
				data.add(p);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int agregarProducto(ProductoDTO p) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_producto values (?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, p.getCodProducto());
			pstm.setBinaryStream(2, p.getImagen());
			pstm.setString(3, p.getNombre());
			pstm.setInt(4, p.getIdCategoriaProducto());
				pstm.setString(5, p.getDescripcion());
				pstm.setInt(6, p.getStock());
				pstm.setDouble(7, p.getPrecio());
					pstm.setString(8, p.getFechaRegistro());
		
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
	public int actualizarProducto(ProductoDTO p) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update tb_producto set imagen=?, nombre=?,  idCategoriaProducto=?,descripcion=?,stock=?,precio=?,fechaRegistro=?  where codProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setBinaryStream(1, p.getImagen());
			
			pstm.setString(2, p.getNombre());
			pstm.setInt(3, p.getIdCategoriaProducto());
			pstm.setString(4, p.getDescripcion());
			pstm.setInt(5, p.getStock());
			pstm.setDouble(6, p.getPrecio());
			pstm.setString(7, p.getFechaRegistro());
			pstm.setString(8, p.getCodProducto());
			estado = pstm.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarProducto(String idProducto) {
		
		
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_producto where codProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idProducto);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
		
		
		
	}

	@Override
	public String generarCodigo() {
	String codigo ="P0001";
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {			
			con=MySqlDBConexion.getConexion();
			
			String sql="select substring(max(codProducto),2) from tb_producto";
			
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				codigo=String.format("P%04d",rs.getInt(1)+1);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
	
			System.out.println("Error en generar Codigo de Producto");
		
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
	public ProductoDTO buscarProducto(String cod) {
		// TODO Auto-generated method stub
		ProductoDTO proc = null;
				Connection cn = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;
						
				try {
					cn = MySqlDBConexion.getConexion();
					String sql = "select * from tb_producto where codProducto=?";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, cod);
					rs = pstm.executeQuery();
					if (rs.next()) {
						proc = new ProductoDTO();
						proc.setCodProducto(rs.getString(1));
						proc.setImagen(rs.getBinaryStream(2));
						proc.setNombre(rs.getString(3));
						proc.setIdCategoriaProducto(rs.getInt(4));
						proc.setDescripcion(rs.getString(5));
						proc.setStock(rs.getInt(6));
						proc.setPrecio(rs.getDouble(7));
						proc.setFechaRegistro(rs.getString(8));
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return proc;
	}
	
	
	public void listarImg(String cod,HttpServletResponse response) {
		
		String sql ="select * from tb_producto where codProducto="+cod;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		InputStream inputStream=null;
		
		OutputStream outputStream=null;
		
		BufferedInputStream bufferedInputStream=null;
		
		BufferedOutputStream bufferedOutputStream=null;
		
		response.setContentType("image/*");

		try {
			
			outputStream=response.getOutputStream();
			cn = MySqlDBConexion.getConexion();
			pstm=cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
			
				inputStream=rs.getBinaryStream("imagen");
				
				
				
			}
			bufferedInputStream= new BufferedInputStream(inputStream);
			
			bufferedOutputStream=new BufferedOutputStream(outputStream);
			
			int i=0;
			
			while((i=bufferedInputStream.read())!=-1) {
				bufferedOutputStream.write(i);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
		
		
	}
	
	
	
	
	}
	
	

