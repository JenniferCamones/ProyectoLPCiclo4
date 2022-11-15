package beans;

public class ProveedorDTO {


	private String codProv;
	private String nombre;
	private String direccion;
	private String correo;
	
	
	
	
		public ProveedorDTO() {
		super();
	}

		public ProveedorDTO(String codProv, String nombre, String direccion, String correo) {
		super();
		this.codProv = codProv;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}
	
	public String getCodProv() {
		return codProv;
	}
	public void setCodProv(String codProv) {
		this.codProv = codProv;
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

	
	
	
	
	
}
