package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		Rectangulo r1 = new Rectangulo(10,5);
		/*r1.setAltura(10);
		r1.setBase(5);*/
		int resultado = r1.calcularArea();

		Rectangulo r2 = new Rectangulo(20,5);
		/*r2.setAltura(20);
		r2.setBase(5);*/
		int resultado2 = r2.calcularArea();

		System.out.println("Área r1: " + resultado);
		System.out.println("Área r2: " + resultado2);

		// Perímetro
		double perimetro1 = r1.calcularParametro();
		double perimetro2 = r2.calcularParametro();
		System.out.println("Perímetro r1: " + perimetro1);
		System.out.println("Perímetro r2: " + perimetro2);

	}
}