package beans;

public class ProveedorDTO {

	private int idProveedor;
	private String nombre;
	private String direccion;
	private String correo;
	private String fechaRegistro;
	private int usuarioRegistro;
	private String fechaModifica;
	private int usuarioModifica;
		
	public ProveedorDTO() {
		
	}
		
	public ProveedorDTO(int idProveedor, String nombre, String direccion, String correo, String fechaRegistro,
			int usuarioRegistro, String fechaModifica, int usuarioModifica) {	
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaModifica = fechaModifica;
		this.usuarioModifica = usuarioModifica;
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
	public int getUsuarioRegistro() {
		return usuarioRegistro;
	}
	public void setUsuarioRegistro(int empleadoRegistro) {
		this.usuarioRegistro = empleadoRegistro;
	}
	public String getFechaModifica() {
		return fechaModifica;
	}
	public void setFechaModifica(String fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
	public int getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(int empleadoModifica) {
		this.usuarioModifica = empleadoModifica;
	}
	
	
}
