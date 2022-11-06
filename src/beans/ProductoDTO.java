package beans;

public class ProductoDTO {
	private int idProducto;
	private String nombre;
	private int stockActual;
	private double precioActual;
	private String fechaRegistro;
    private int empleadoRegistro;
	private String fechaModifica;
	private int empleadoModifica;
	private int idCategoriaPro;
	private String nombre_cate;
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public double getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(double precioActual) {
		this.precioActual = precioActual;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getEmpleadoRegistro() {
		return empleadoRegistro;
	}

	public void setEmpleadoRegistro(int empleadoRegistro) {
		this.empleadoRegistro = empleadoRegistro;
	}

	public String getFechaModifica() {
		return fechaModifica;
	}

	public void setFechaModifica(String fechaModifica) {
		this.fechaModifica = fechaModifica;
	}

	public int getEmpleadoModifica() {
		return empleadoModifica;
	}

	public void setEmpleadoModifica(int empleadoModifica) {
		this.empleadoModifica = empleadoModifica;
	}

	public int getIdCategoriaPro() {
		return idCategoriaPro;
	}

	public void setIdCategoriaPro(int idCategoriaPro) {
		this.idCategoriaPro = idCategoriaPro;
	}

	public String getNombre_cate() {
		return nombre_cate;
	}

	public void setNombre_cate(String nombre_cate) {
		this.nombre_cate = nombre_cate;
	}

}
