package com.clearminds.componentes;

public class Producto {
	private String nombre;
	private String codigo;
	private double precio;
	
	public Producto(String codigo, String nombre, double precio) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
	}

	public void incrementarPrecio(int valor) {
		precio+=(precio*valor)/100;
	}
	
	public void disminuirPrecio(double valor) {
		precio-=valor;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
