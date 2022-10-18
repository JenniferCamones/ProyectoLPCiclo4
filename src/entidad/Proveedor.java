package entidad;

public class Proveedor {

	private int idProveedor;
	private String nombre;
	private String direccion;
	private String correo;
	private String fechaRegistro;
	private int empleadoRegistro;
	private String fechaModifica;
	private int empleadoModifica;
		
	public Proveedor() {
		
	}
		
	public Proveedor(int idProveedor, String nombre, String direccion, String correo, String fechaRegistro,
			int empleadoRegistro, String fechaModifica, int empleadoModifica) {	
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaRegistro = fechaRegistro;
		this.empleadoRegistro = empleadoRegistro;
		this.fechaModifica = fechaModifica;
		this.empleadoModifica = empleadoModifica;
	}
	
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	
	
}
