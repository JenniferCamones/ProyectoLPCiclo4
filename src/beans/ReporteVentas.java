package beans;

import java.util.Date;

public class ReporteVentas {
	private String numeroBoleta;
	private Date fechaBoleta;
	private String codigoCliente;
	private String NombreCompletoCli;
	private String codigoEmpleado;
	private String NombreCompletoEmp;
	private double totalBoleta;
	private String codProducto;
	private int cantidad;
	private double precioUnidad;
	private double importeTotal;
	
	
	
	public ReporteVentas(){	
	}
	public ReporteVentas(String numeroBoleta, Date fechaBoleta, String codigoCliente, String nombreCompletoCli,
			String codigoEmpleado, String nombreCompletoEmp, double totalBoleta) {
		super();
		this.numeroBoleta = numeroBoleta;
		this.fechaBoleta = fechaBoleta;
		this.codigoCliente = codigoCliente;
		NombreCompletoCli = nombreCompletoCli;
		this.codigoEmpleado = codigoEmpleado;
		NombreCompletoEmp = nombreCompletoEmp;
		this.totalBoleta = totalBoleta;
		
		
	}
	
	public ReporteVentas(String numeroBoleta, Date fechaBoleta, String codigoCliente, String nombreCompletoCli,
			String codigoEmpleado, String nombreCompletoEmp, double totalBoleta, String codProducto, int cantidad,
			double precioUnidad, double importeTotal) {
		super();
		this.numeroBoleta = numeroBoleta;
		this.fechaBoleta = fechaBoleta;
		this.codigoCliente = codigoCliente;
		NombreCompletoCli = nombreCompletoCli;
		this.codigoEmpleado = codigoEmpleado;
		NombreCompletoEmp = nombreCompletoEmp;
		this.totalBoleta = totalBoleta;
		this.codProducto = codProducto;
		this.cantidad = cantidad;
		this.precioUnidad = precioUnidad;
		this.importeTotal = importeTotal;
	}
	
	public String getNumeroBoleta() {
		return numeroBoleta;
	}
	public void setNumeroBoleta(String numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}
	public Date getFechaBoleta() {
		return fechaBoleta;
	}
	public void setFechaBoleta(Date fechaBoleta) {
		this.fechaBoleta = fechaBoleta;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNombreCompletoCli() {
		return NombreCompletoCli;
	}
	public void setNombreCompletoCli(String nombreCompletoCli) {
		NombreCompletoCli = nombreCompletoCli;
	}
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	public String getNombreCompletoEmp() {
		return NombreCompletoEmp;
	}
	public void setNombreCompletoEmp(String nombreCompletoEmp) {
		NombreCompletoEmp = nombreCompletoEmp;
	}
	public double getTotalBoleta() {
		return totalBoleta;
	}
	public void setTotalBoleta(double totalBoleta) {
		this.totalBoleta = totalBoleta;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
		
}
