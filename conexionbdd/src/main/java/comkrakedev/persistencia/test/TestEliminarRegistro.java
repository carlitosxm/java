package comkrakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminRegistroEntradas;

public class TestEliminarRegistro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AdminRegistroEntradas.eliminar(99);
			System.out.println("Eliminacion ok");
		} catch (Exception e) {
			System.out.println("Error al eliminar"+e);
			// TODO: handle exception
		}
	}

}
