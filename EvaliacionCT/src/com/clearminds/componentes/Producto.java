package com.clearminds.componentes;

public class Producto {
	private String nombre;
	private double precio;
	private String codigo;
	
	public Producto ( String codigo,String nombre, double precio){
		this.codigo=codigo;
		this.nombre=nombre;
		this.precio=precio;
	}
	
	public void incrementarPrecio (int porcentaje) {
		double incremento=(precio*porcentaje)/100;
		precio+=incremento;		
	}
	
	public void disminuirPrecio (double descuento) {
		precio-=descuento;		
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
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
