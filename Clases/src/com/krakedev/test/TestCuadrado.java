package com.krakedev.test;

import com.krakedev.Cuadrado;

public class TestCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado c1 = new Cuadrado(4);
		Cuadrado c2 = new Cuadrado(2);
		Cuadrado c3 = new Cuadrado(10);
		/*c1.setLado(4);
		c2.setLado(2);
		c3.setLado(10);*/
		double a1 = c1.calcularArea();
		double p1 = c1.calcularPerimetro();
		System.out.println(""+a1);
		System.out.println(""+p1);
		double a2 = c2.calcularArea();
		double p2 = c2.calcularPerimetro();
		System.out.println(""+a2);
		System.out.println(""+p2);
		double a3 = c3.calcularArea();
		double p3 = c3.calcularPerimetro();
		System.out.println(""+a3);
		System.out.println(""+p3);
	}

}
