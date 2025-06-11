package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		Auto auto1=new Auto();
		Auto auto2=new Auto();
		
		auto1.marca="kia";
		auto1.anio=2024;
		auto1.precio=1400.00f;
		
		auto2.marca="BMW";
		auto2.anio=2020;
		auto2.precio=35000.00f;
		
		System.out.println("AUTO 1");
		System.out.println("Marca: "+auto1.marca);
		System.out.println("Año: "+auto1.anio);
		System.out.println("Precio: "+auto1.precio);
		System.out.println("------------------------------");
		System.out.println("AUTO 2");
		System.out.println("Marca: "+auto2.marca);
		System.out.println("Año: "+auto2.anio);
		System.out.println("Precio: "+auto2.precio);

	}

}
