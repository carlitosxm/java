package com.cmc.directorio.test;

import com.crc.directorio.entidades.AdminTelefono;
import com.crc.directorio.entidades.Telefono;

public class TestTelefono3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono tel1=new Telefono("movi", "098745218", 10);
		Telefono tel2=new Telefono("movi", "0987585963", 20);
		Telefono tel3=new Telefono("claro", "096253687", 10);
		AdminTelefono ad=new AdminTelefono();
		int contarMovi=ad.contarMovi(tel1, tel2, tel3);
		System.out.println("Lineas movi: "+contarMovi);
	}

}
