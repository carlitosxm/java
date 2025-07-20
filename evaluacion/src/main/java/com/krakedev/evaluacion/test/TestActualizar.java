package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestActualizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServiciosCategoria.actualizar(new Categoria("C004","Higi"));
		} catch (KrakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
