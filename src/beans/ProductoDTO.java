package beans;

import java.io.InputStream;

public class ProductoDTO {
	
	private String codProducto;
	private InputStream imagen;
	private String nombre;
	private int idCategoriaProducto;
	private String descripcion;
	private int stock;
	private double precio;
	private String fechaRegistro;
	
	private String categoria;
	
	
	
	

	public ProductoDTO() {
		super();
	}
	public ProductoDTO(String categoria,String codProducto, InputStream imagen, String nombre, int idCategoriaProducto, String descripcion,
			int stock, double precio, String fechaRegistro) {
		super();
		this.codProducto = codProducto;
		this.imagen = imagen;
		this.nombre = nombre;
		this.idCategoriaProducto = idCategoriaProducto;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.fechaRegistro = fechaRegistro;
		this.categoria = categoria;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public InputStream getImagen() {
		return imagen;
	}
	public void setImagen(InputStream inputStream) {
		this.imagen = inputStream;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdCategoriaProducto() {
		return idCategoriaProducto;
	}
	public void setIdCategoriaProducto(int idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
	
}
