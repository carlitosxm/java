package com.krakedev.moduloii.evaluacionfinal.test;

import java.text.ParseException;

import com.krakedev.moduloii.evaluacionfinal.entidades.Libro;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosLibros;
import com.krakedev.moduloii.evaluacionfinal.utils.Convertidor;

public class TestInsertarLibro {

	public static void main(String[] args) throws ParseException, KrakeException {
		// TODO Auto-generated method stub
		Libro libro=new Libro("Libro",2,1,Convertidor.convertirFecha("1992/12/19 18:05:20"),true);
		try {
			ServiciosLibros.insertar(libro);
		} catch (KrakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
