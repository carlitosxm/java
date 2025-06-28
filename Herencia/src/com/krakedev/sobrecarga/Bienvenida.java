package com.krakedev.sobrecarga;

public class Bienvenida {
	public void Saludar(String nombre) {
		System.out.println("Hola "+nombre);
	}
	public void Saludar(String nombre, String apellido) {
		System.out.println("Hola "+nombre);
	}
}
