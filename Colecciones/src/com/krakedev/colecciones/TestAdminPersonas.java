package com.krakedev.colecciones;

import java.util.ArrayList;

public class TestAdminPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminPersonas admin=new AdminPersonas();
		admin.agregar(new Persona("mario", "lopez", 50));
		admin.agregar(new Persona("Maria", "lopez", 10));
		admin.agregar(new Persona("Jazmin", "lopez", 50));
		admin.imprimir();
		Persona p1=admin.buscarPorNombre("mario");
		if(p1!=null) {
		System.out.println("Econtrado "+p1.getNombre()+" "+p1.getApellido());	
		}else {
			System.out.println("No enxiste la persona de nombre");
		}
		ArrayList<Persona> personasMayores=admin.buscarMayores(25);
		System.out.println(personasMayores.size());
	}
}
