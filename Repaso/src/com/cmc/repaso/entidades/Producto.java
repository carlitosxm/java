package com.cmc.repaso.entidades;

public class Producto {
	private String nombre;
	private double precio;
	
	public Producto (String nombre, double precio) {
		this.nombre=nombre;
		this.precio=precio;
	}
	
	public double CalcularPrecioPromo(int porcentaje) {
		double descuento=((getPrecio()*porcentaje)/100);
		return getPrecio()-descuento; 
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		if (precio<0) {
			this.precio = precio*(-1);
		}else {
			this.precio = precio;
		}
	}
	
}
