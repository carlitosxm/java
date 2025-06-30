package comkrakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestEliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AdminPersonas.eliminar("1721949752");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: "+e.getMessage());
		}
	}

}
