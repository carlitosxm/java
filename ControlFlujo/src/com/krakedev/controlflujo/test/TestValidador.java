package com.krakedev.controlflujo.test;

import com.kravedev.controlflujo.Validador;

public class TestValidador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Validador v=new Validador();
		v.validadEdad(20);
		v.validadEdad(18);
		v.validadEdad(10);
		v.validadEdad(-3);
	}

}
