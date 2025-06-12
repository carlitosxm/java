package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		Persona p;// Declaro variable tipo persona
		p = new Persona();// instancio un obe¿jeto persona
		Persona p2 = new Persona();

		//modificar atributos
		p.setNombre("Jose");
		p.setEdad(45); 
		p.setEstatura(1.56); 

		// accedo a los atributos
		System.out.println("nombre: " + p.getNombre());
		System.out.println("edad: " + p.getEdad());
		System.out.println("estatura: " + p.getEstatura());

		p2.setNombre("Angelina");
		System.out.println("nombre: " + p2.getNombre());

	}

}
