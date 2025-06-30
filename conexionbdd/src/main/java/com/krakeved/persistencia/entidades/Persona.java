package com.krakeved.persistencia.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Persona {
	private String cedula;
	private String nombre;
	private String apellido;
	private EstadoCivil estadoCivil;
	private int numero_hijos;
	private double estatura;
	private BigDecimal cantidad_ahorrada;
	private Date fecha_nacimiento;
	private Date hora_nacimientos;
	
	
	
	public Persona() {
	}

	public Persona(String cedula, String nombre, String apellido, EstadoCivil estadoCivil, int numero_hijos,
			double estatura, BigDecimal cantidad_ahorrada, Date fecha_nacimiento, Date hora_nacimientos) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estadoCivil = estadoCivil;
		this.numero_hijos = numero_hijos;
		this.estatura = estatura;
		this.cantidad_ahorrada = cantidad_ahorrada;
		this.fecha_nacimiento = fecha_nacimiento;
		this.hora_nacimientos = hora_nacimientos;
	}

	public Persona(String cedula, String nombre, String apellido, EstadoCivil estadoCivil) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estadoCivil = estadoCivil;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public int getNumero_hijos() {
		return numero_hijos;
	}
	public void setNumero_hijos(int numero_hijos) {
		this.numero_hijos = numero_hijos;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public BigDecimal getCantidad_ahorrada() {
		return cantidad_ahorrada;
	}
	public void setCantidad_ahorrada(BigDecimal cantidad_ahorrada) {
		this.cantidad_ahorrada = cantidad_ahorrada;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Date getHora_nacimientos() {
		return hora_nacimientos;
	}
	public void setHora_nacimientos(Date hora_nacimientos) {
		this.hora_nacimientos = hora_nacimientos;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", estadoCivil="
				+ estadoCivil + ", numero_hijos=" + numero_hijos + ", estatura=" + estatura + ", cantidad_ahorrada="
				+ cantidad_ahorrada + ", fecha_nacimiento=" + fecha_nacimiento + ", hora_nacimientos="
				+ hora_nacimientos + "]";
	}
	
}
