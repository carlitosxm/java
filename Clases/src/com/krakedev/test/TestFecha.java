package com.krakedev.test;

import com.krakedev.Fecha;

public class TestFecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fecha f1=new Fecha();
		f1.setAnio(2000);
		f1.setMes(12);
		f1.setDia(12);
		
		System.out.println("Año: "+f1.getAnio());
		System.out.println("Mes: "+f1.getMes());
		System.out.println("Dia: "+f1.getDia());
		
	}

}
