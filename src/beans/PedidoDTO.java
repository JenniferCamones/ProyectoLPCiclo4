package beans;

public class PedidoDTO {
	private int idPedido; 
	private String numeroPedido;  
	private String nombre;
	private String fecha;
	private int idCliente;
	private int idEmpleado;
	private String estado;
	
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(int idPedido, String numeroPedido, String nombre, String fecha, int idCliente, int idEmpleado,
			String estado) {		
		this.idPedido = idPedido;
		this.numeroPedido = numeroPedido;
		this.nombre = nombre;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.estado = estado;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
