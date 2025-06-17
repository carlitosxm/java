package com.krakedev.test;

import com.krakedev.composicion.Direccion;
import com.krakedev.composicion.Persona;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1=new Persona();
		p1.setNombre("Carlos");
		p1.setApellido("Tipan");
		Direccion dir=new Direccion();
		dir.setCallePrincipal("Franciso Suarez");
		dir.setCalleSecundaria("Pasaje 4");
		dir.setNumero("oe6-26");
		p1.setDireccion(dir);
		String nombre=p1.getNombre();
		Direccion d1=p1.getDireccion(); 
		System.out.println(nombre);
		System.out.println(d1.getCallePrincipal());
		p1.imprimir();
		Persona p2=new Persona();
		p2.setNombre("Jose");
		Direccion dir2=new Direccion("Baños", "PAsaje", "oe55");
		p2.imprimir();
		System.out.println("fin");
		Persona p3=new Persona();
		p3.setDireccion(new Direccion("xx", "yy", "zz"));
		p3.imprimir();
	}

}
