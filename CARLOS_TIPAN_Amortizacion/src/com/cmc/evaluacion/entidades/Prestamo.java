package com.cmc.evaluacion.entidades;

import java.util.ArrayList;

public class Prestamo {
	private double monto;
	private double interes;
	private int plazo;
	private ArrayList<Cuota> cuotas; 
	private Cliente cliente;
	public Prestamo(double monto, double interes, int plazo) {
		super();
		this.monto = monto;
		this.interes = interes;
		this.plazo = plazo;
		this.cuotas = new ArrayList<>(plazo);
	}
	public Cliente getCliente() {
	    return cliente;
	}
	public ArrayList<Cuota> getCuotas() {
		return cuotas;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	public void mostrarPrestamo() {
        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        }
        System.out.println("[monto=" + monto + ", interes=" + interes + ", plazo=" + plazo + "]");
    }
	
}
