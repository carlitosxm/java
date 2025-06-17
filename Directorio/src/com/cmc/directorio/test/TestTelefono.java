package com.cmc.directorio.test;

import com.crc.directorio.entidades.Telefono;

public class TestTelefono {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf=new Telefono("movi", "09941234123", 10);
		System.out.println("Operado : "+telf.getOperadora() );
		System.out.println("Número: "+telf.getNumero() );
		System.out.println("Código: "+telf.getCodigo() );
	}

}
