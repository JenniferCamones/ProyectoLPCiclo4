package beans;

public class ClienteDTO {
//1
	
	
	private String  codcli;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String correo;
	private String usuario;
	private String clave;
	private int idTipo;
	
	
	
	
	public ClienteDTO() {
		super();
	}
	public ClienteDTO(String codcli, String nombre, String apellido, String telefono, String direccion, String correo,
			String usuario, String clave, int idTipo) {
		super();
		this.codcli = codcli;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
		this.idTipo = idTipo;
	}
	public String getCodcli() {
		return codcli;
	}
	public void setCodcli(String codcli) {
		this.codcli = codcli;
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
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	

	
	
	
	
}
