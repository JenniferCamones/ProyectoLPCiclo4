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
	
	
	
	
	
	
	
	
}
