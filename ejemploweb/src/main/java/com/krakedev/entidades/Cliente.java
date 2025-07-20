package com.krakedev.entidades;

public class Cliente {
	private String nombre;
	private String cedula;
	private int numeroHijos;
	
	public Cliente() {
		super();
	}
	public Cliente(String nombre, String cedula,int numeroHijos) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.numeroHijos = numeroHijos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public int getNumeroHijos() {
		return numeroHijos;
	}
	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", cedula=" + cedula + "]";
	}
	
	
}
