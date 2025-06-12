package com.krakedev;

public class Cuadrado {
	public int lado;
	public double calcularArea() {
		double area=lado^2;
		return area;
	}
	public double calcularPerimetro() {
		double perimetro=lado*4;
		return perimetro;
	}
}
