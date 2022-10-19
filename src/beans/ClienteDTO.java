package beans;

public class ClienteDTO {
//1
	private int idCliente;
	private String nombre; 
	private String direccion;
	private String dni;			 
	private String telefono;
	//5
	
	public ClienteDTO() {
		
	}
	public ClienteDTO(int idCliente, String nombre, String direccion, String dni, String telefono) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.telefono = telefono;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
