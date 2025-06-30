package com.krakeved.persistencia.entidades;

import java.util.Date;

public class RegistrosEntrada {
	private int codigo_registro;
	private String cedula_empleado;
	private Date fecha;
	private Date hora;
	private Empleado empleado;
	public RegistrosEntrada(int codigo_registro, String cedula_empleado, Date fecha, Date hora, Empleado empleado) {
		super();
		this.codigo_registro = codigo_registro;
		this.cedula_empleado = cedula_empleado;
		this.fecha = fecha;
		this.hora = hora;
		this.empleado = empleado;
	}
	public int getCodigo_registro() {
		return codigo_registro;
	}
	public void setCodigo_registro(int codigo_registro) {
		this.codigo_registro = codigo_registro;
	}
	public String getCedula_empleado() {
		return cedula_empleado;
	}
	public void setCedula_empleado(String cedula_empleado) {
		this.cedula_empleado = cedula_empleado;
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
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
