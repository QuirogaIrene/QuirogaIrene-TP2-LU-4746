package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private LocalDate fechaDePago;
	private double montoPagado; 
	
	
	
	public PagoEfectivo(LocalDate fechaDePago, double montoPagado) {
		super();
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}
	
	
	public LocalDate getFechaDePago() {
		return fechaDePago;
	}


	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}


	public double getMontoPagado() {
		return montoPagado;
	}


	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}


	@Override
	public void realizarPago(double monto) {
		setMontoPagado(this.montoPagado-(this.montoPagado*10/100));
		
	}
	@Override
	public void imprimirRecibo() {
		System.out.println(">>>>Recibo de Pago<<<<");
		System.out.println("Fecha de pago: "+getFechaDePago());
		System.out.println("Monto pagado: $"+getMontoPagado());
		System.out.println(">>>>GRACIAS POR SU COMPRA <<<<");
	}
}
	

