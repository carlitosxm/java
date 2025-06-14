package com.krakedev.test;
import com.krakedev.Calculadora;

public class TestCalculador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calculador = new Calculadora();
		int resultadosuma;
		int resultadoresta;
		double resultadomultiplicar;
		double resultadodividir;
		double resultadopromediar;
		resultadosuma = calculador.sumar(5, 3);
		System.out.println("RESULTADO: " + resultadosuma);
		resultadoresta = calculador.restar(10, 3);
		System.out.println("RESULTADO: " + resultadoresta);
		resultadomultiplicar = calculador.multiplicar(10, 3);
		System.out.println("RESULTADO: " + resultadomultiplicar);
		resultadodividir = calculador.dividir(10, 5);
		System.out.println("RESULTADO: " + resultadodividir);
		resultadopromediar = calculador.promediar(10, 10,10);
		System.out.println("RESULTADO: " + resultadopromediar);
		calculador.mostrarResultado();
	}
}
