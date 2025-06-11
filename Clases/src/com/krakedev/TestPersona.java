package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		Persona p;// Declaro variable tipo persona
		p = new Persona();// instancio un obe¿jeto persona
		Persona p2 = new Persona();

		//modificar atributos
		p.nombre = "Jose";
		p.edad = 45;
		p.estatura = 1.56;

		// accedo a los atributos
		System.out.println("nombre: " + p.nombre);
		System.out.println("edad: " + p.edad);
		System.out.println("estatura: " + p.estatura);

		p2.nombre = "Angelina";
		System.out.println("nombre: " + p2.nombre);

	}

}
