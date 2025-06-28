package com.krakedev.estaticos.ejecicio.test;

import com.krakedev.estaticos.ejecicio.utils.*;
import com.krakedev.estaticos.ejecicio.entidades.Alarma;
import com.krakedev.estaticos.ejecicio.logica.AdminAlarmas;

public class TestAlarma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminAlarmas aa=new AdminAlarmas();
		Alarma a1=(new Alarma(DiasSemana.LUNES, 10, 20));
		aa.agregarAlarma(a1);
		Alarma a2=(new Alarma(DiasSemana.MARTES, 14, 40));
		aa.agregarAlarma(a2);
		Alarma a3=(new Alarma(DiasSemana.MIERCOLES, 18, 28));
		aa.agregarAlarma(a3);
		Alarma a4=(new Alarma(DiasSemana.VIERNES, 20, 1));
		aa.agregarAlarma(a4);
		System.out.println(aa.getAlarmas());
	}

}
