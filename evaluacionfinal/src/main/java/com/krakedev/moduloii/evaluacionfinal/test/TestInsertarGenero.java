package com.krakedev.moduloii.evaluacionfinal.test;

import com.krakedev.moduloii.evaluacionfinal.entidades.Genero;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosGeneros;

public class TestInsertarGenero {

	public static void main(String[] args) {
		Genero genero=new Genero("Prueba");
		try {
			ServiciosGeneros.agregarGenero(genero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
