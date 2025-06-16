package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class ValidarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Validacion validar=new Validacion();
		boolean resultado=validar.validarMonto(100);
		System.out.println(" "+resultado);
	}

}
