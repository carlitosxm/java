package com.krakedev.endidades;

import java.util.ArrayList;

public class Nota {
	private double calificacion;
	private String materia;
	
	public Nota(String materia, double calificacion) {
		this.calificacion = calificacion;
		this.materia = materia;
	}
	
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public void mostrar() {
		System.out.println("Clase [Calificacion="+calificacion+", Materia="+materia);
	}
	
}

