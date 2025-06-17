package com.cmc.directorio.test;

import com.crc.directorio.entidades.Contactos;
import com.crc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telef=new Telefono("movi", "0999685421", 10);
		Contactos c=new Contactos("Carlos", "Tipan", telef, 0.50);
		System.out.println("Nombre :"+c.getNombre());
		System.out.println("Apellido :"+c.getApellido());
		System.out.println("Tipo Telefono :"+telef.getOperadora());
		System.out.println("Peso :"+c.getPeso());
		System.out.println("Operador :"+telef.getOperadora());
		System.out.println("Número :"+telef.getNumero());
	}

}
