package com.krakedev.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class AdminPersonas {
	private ArrayList<Persona> personas;

	public AdminPersonas() {
		personas = new ArrayList<Persona>();
	}

	public void agregar(Persona persona) {
		personas.add(persona);
	}

	public void imprimir() {
		Persona elementoPersonas;
		for (int i = 0; i < personas.size(); i++) {
			elementoPersonas = personas.get(i);
			System.out.println(elementoPersonas.getNombre() + " " + elementoPersonas.getApellido() + " "
					+ elementoPersonas.getEdad());
		}
	}

	public Persona buscarPorNombre(String nombre) {
		Persona personaEncontrada = null;
		Persona elementoPersona = null;
		for (int i = 0; i < personas.size(); i++) {
			elementoPersona = personas.get(i);
			if (elementoPersona.getNombre().equals(nombre)) {
				personaEncontrada = elementoPersona;
			}
		}
		return personaEncontrada;
	}

	public ArrayList<Persona> buscarMayores(int edad) {
		ArrayList<Persona> mayores = new ArrayList<Persona>();
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getEdad() > edad) {
				mayores.add(personas.get(i));
			}
		}
		return mayores;
	}
}
