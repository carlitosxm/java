package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestBuscarCategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Categoria c=ServiciosCategoria.buscarPorId("C004");
			if(c==null) {
				System.out.println("no existe lacategoria");
			}
		} catch (KrakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
