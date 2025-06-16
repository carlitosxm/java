package com.cmc.repaso.entidades;

public class Item {
	private String nombre;
	private int productosActuales;
	private int productosDevueltos;
	private int productosVendidos;
	
	public void imprimir() {
		System.out.println("Nombre: "+getNombre());
		System.out.println("Productos Actuales: "+getProductosActuales());
		System.out.println("Productos Devueltos: "+getProductosDevueltos());
		System.out.println("Productos Vendidos: "+getProductosVendidos());
	}
	
	public void vender(int cantidadVendida) {
		this.productosActuales -= cantidadVendida;
		this.productosVendidos += cantidadVendida;
	}
	
	public void devolver (int cantidadVendida) {
		this.productosActuales += cantidadVendida;
		this.productosVendidos -= cantidadVendida;
		this.productosDevueltos += cantidadVendida;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProductosActuales() {
		return productosActuales;
	}
	public void setProductosActuales(int productosActuales) {
		this.productosActuales = productosActuales;
	}
	public int getProductosDevueltos() {
		return productosDevueltos;
	}
	public void setProductosDevueltos(int productosDevueltos) {
		this.productosDevueltos = productosDevueltos;
	}
	public int getProductosVendidos() {
		return productosVendidos;
	}
	public void setProductosVendidos(int productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
	
	
}
