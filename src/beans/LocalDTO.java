package beans;

public class LocalDTO {

	
	private String codLoc;
	private String departamento;
	private String 	distrito;
	private String direccion;
	private String telefono;
	
	
	
	
	
	
	
	public LocalDTO() {
		super();
	}
	public LocalDTO(String codLoc, String departamento, String distrito, String direccion, String telefono) {
		super();
		this.codLoc = codLoc;
		this.departamento = departamento;
		this.distrito = distrito;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public String getCodLoc() {
		return codLoc;
	}
	public void setCodLoc(String codLoc) {
		this.codLoc = codLoc;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
	
}
