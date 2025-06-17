package com.cmc.directorio.test;

import com.crc.directorio.entidades.AdminTelefono;
import com.crc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono tel1=new Telefono("movi", "098745218", 10);
		Telefono tel2=new Telefono("movi", "0987585963", 20);
		Telefono tel3=new Telefono("claro", "096253687", 10);
		Telefono tel4=new Telefono("claro", "0962538787", 10);
		AdminTelefono ad=new AdminTelefono();
		int contarMovi=ad.contarClaro(tel1, tel2, tel3,tel4);
		System.out.println("Lineas claro: "+contarMovi);
	}

}
