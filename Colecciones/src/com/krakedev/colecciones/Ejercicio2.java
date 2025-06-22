package com.krakedev.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Persona> personas;
		personas=new ArrayList<Persona>();
		
		personas.add(new Persona("jose", "rio"));
		personas.add(new Persona("luis", "rio"));
		personas.add(new Persona("maria", "rio"));
		
		Persona elementoPersona;
		for(int i=0;i<personas.size();i++) {
			elementoPersona=personas.get(i);
			System.out.println(elementoPersona.getNombre()+" "+elementoPersona.getNombre());
		}
	}

}
