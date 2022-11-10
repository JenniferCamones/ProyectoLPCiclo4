package beans;

public class EmpleadosDTO {

	private String  codemp;
	private String nombre;
	private String apellido;
		private String usuario;
	private String clave;
	private String telefono;
	private String direccion;
	private String correo;

	private int idTipo;

	
	
	
	
	public EmpleadosDTO() {
		super();
	}

	public EmpleadosDTO(String codemp, String nombre, String apellido, String usuario, String clave, String telefono,
			String direccion, String correo, int idTipo) {
		super();
		this.codemp = codemp;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.idTipo = idTipo;
	}

	public String getCodemp() {
		return codemp;
	}

	public void setCodemp(String codemp) {
		this.codemp = codemp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	
	
	
	
	
}
