package comkrakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakeved.persistencia.entidades.Persona;

public class TestConsultaPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Persona> personas= AdminPersonas.buscarPorNombre("a");
			System.out.println(personas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
