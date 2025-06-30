package com.krakeved.persistencia.entidades;

import java.util.Date;

public class Empleado {
	private int codigo_empleado;
	private String nombre; 
	private Date fecha; 
	private Date hora;
	public Empleado() {
		super();
	}
	public Empleado(int codigo_empleado, String nombre, Date fecha, Date hora) {
		super();
		this.codigo_empleado = codigo_empleado;
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
	}
	public int getCodigo_empleado() {
		return codigo_empleado;
	}
	public void setCodigo_empleado(int codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
}
