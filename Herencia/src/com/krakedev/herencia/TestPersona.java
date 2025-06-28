package com.krakedev.herencia;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p=new Persona("1234567890","Carlos");
		System.out.println(p.toString());
		Cuenta c=new Cuenta("Carlos", 500);
		System.out.println(c);
	}
}
