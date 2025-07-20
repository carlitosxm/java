package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestInsertar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServiciosCategoria.insertar(new Categoria("C004","Higiene"));
		} catch (KrakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
