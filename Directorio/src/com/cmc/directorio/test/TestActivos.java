package com.cmc.directorio.test;

import com.crc.directorio.entidades.AdminContactos;
import com.crc.directorio.entidades.Contactos;
import com.crc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono t1=new Telefono("movi", "0985693021", 10);
		Contactos c1=new Contactos("Carlos", "Tipan", t1, 10);
		System.out.println(c1.getNombre()+" tiene Whatsapp: "+c1.getTelefono().getTieneWhatsapp() );
		AdminContactos ac=new AdminContactos();
		ac.activarUsuario(c1);
		System.out.println(c1.getNombre()+" tiene Whatsapp: "+c1.getTelefono().getTieneWhatsapp() );
	}
}
