package comkrakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;
import com.krakeved.persistencia.entidades.EstadoCivil;
import com.krakeved.persistencia.entidades.Persona;

public class TestActualizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstadoCivil ec=new EstadoCivil("U","Union Libre");
		Persona p=new Persona("1721949752","Julio","Jaramillito",ec);
		try {
			Date fechaNac=Convertidor.convertirFecha("2000/12/13");
			Date horaNac=Convertidor.convertirHora("09:23");
			p.setFecha_nacimiento(fechaNac);
			p.setHora_nacimientos(horaNac);
			p.setCantidad_ahorrada(new BigDecimal(1230.45));
			p.setNumero_hijos(50);
			AdminPersonas.actualizar(p);
			System.out.println("Actualizacion correcta");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: "+e.getMessage());
		}
		
	}

}
