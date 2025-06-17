package com.cmc.directorio.test;

import com.crc.directorio.entidades.AdminContactos;
import com.crc.directorio.entidades.Contactos;
import com.crc.directorio.entidades.Telefono;

public class TestContactos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono t1=new Telefono("movi", "0985693021", 10);
		Contactos c1=new Contactos("Carlos", "Tipan", t1, 10);
		Telefono t2=new Telefono("claro", "0985613021", 10);
		Contactos c2=new Contactos("Jose", "Tipan", t2, 19);
		AdminContactos ac=new AdminContactos();
		Contactos pesado=ac.buscarMasPesado(c1, c2);
		System.out.println(pesado.getNombre()+" es el contacto mas pesado: "+pesado.getPeso());
		boolean comOperador=ac.comparaOperadoras(c1, c2);
		System.out.println("Son de la misma operadora: "+comOperador);
	}
}
