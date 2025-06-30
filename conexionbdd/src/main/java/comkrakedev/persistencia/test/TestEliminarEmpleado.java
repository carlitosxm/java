package comkrakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminEmpleado;

public class TestEliminarEmpleado {
	public static void main(String[] args) {
		try {
			AdminEmpleado.eliminar(2222);
			System.out.println("eliminacion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error al eliminar"+e);
		}
	}
}
