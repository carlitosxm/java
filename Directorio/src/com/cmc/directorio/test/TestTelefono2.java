package com.cmc.directorio.test;

import com.crc.directorio.entidades.AdminTelefono;
import com.crc.directorio.entidades.Telefono;

public class TestTelefono2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf=new Telefono("movi", "098234234",20);
		AdminTelefono at=new AdminTelefono();
		at.activarMensajeria(telf);
		System.out.println("Operado : "+telf.getOperadora() );
		System.out.println("Número: "+telf.getNumero() );
		System.out.println("Código: "+telf.getCodigo() );
		System.out.println("Operado : "+telf.getTieneWhatsapp() );
	}

}
