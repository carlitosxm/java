package comkrakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.servicios.AdminEmpleado;
import com.krakeved.persistencia.entidades.Empleado;

public class TestVarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Empleado> e= AdminEmpleado.buscarPorNombre("a");
			System.out.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
