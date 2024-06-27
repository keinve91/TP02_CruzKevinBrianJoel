package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{

	String numeroTarjeta;
	LocalDate fechaDePago;
	double montoPagado;
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
		
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaDePago, double monto) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = monto;
	}

   

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
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
		double recarga = monto * 0.15;
		double montoTotal = getMontoPagado() + recarga;
		setMontoPagado(montoTotal);
	}

	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("------ Tarjeta ------");
		System.out.println("Nro de tarjeta: " + numeroTarjeta);
		System.out.println("Fecha de pago: " + formatter.format(fechaDePago));
		System.out.println("Monto pagado: $" + montoPagado);
	}

}